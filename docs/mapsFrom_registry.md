# Removing `toDTO()` from Domain Objects

## The Problem

`ChestState` and `PlayerState` previously implemented `Persistable`, which required a `toDTO()` method:

```java
@Override
public PersistableDTO toDTO() {
    return new ChestStateDTO(this);
}
```

This forced the domain class to import its own DTO — an inward-to-outward dependency that violates hexagonal architecture. The domain should know nothing about the persistence adapter layer.

## The Solution

### `@MapsFrom` annotation

A new annotation lives at the port layer (`com.github.game.state`):

```java
@Target(ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.RUNTIME)
public @interface MapsFrom {
    Class<? extends Persistable> value();
}
```

It is placed on the DTO constructor that accepts the domain object:

```java
@MapsFrom(ChestState.class)
public ChestStateDTO(ChestState state) { ... }
```

This is outward → inward (correct direction): the DTO knows about the domain, not the other way around.

### `PersistableMappingRegistry`

At startup, the registry scans all `PersistableDTO` implementations discovered via `ServiceLoader` (already registered with `@AutoService`) and builds a `Map<Class<? extends Persistable>, Constructor<? extends PersistableDTO>>`.

It validates eagerly — if any DTO is missing a `@MapsFrom` constructor, or has more than one, it throws `IllegalStateException` immediately rather than failing silently at save time.

`GameStatePersistence` now calls the registry instead of the domain object:

```java
// before
gameState.getAllStateObjects().forEach((key, value) -> dtoObjects.put(key, value.toDTO()));

// after
gameState.getAllStateObjects().forEach((key, value) -> dtoObjects.put(key, mappingRegistry.toDTO(value)));
```

### `Persistable` is now a marker interface

With `toDTO()` removed, `Persistable` carries no methods. Domain objects implement it purely to declare that they participate in the persistence model.

## Package Structure

DTOs were moved from their domain packages into `com.github.game.state`:

| Old location | New location |
|---|---|
| `com.github.game.world.ChestStateDTO` | `com.github.game.state.ChestStateDTO` |
| `com.github.game.player.PlayerStateDTO` | `com.github.game.state.PlayerStateDTO` |

This places all persistence adapter code in one package, with domain packages (`world`, `player`) having no knowledge of it.

The `PlayerState` reconstruction constructor was also made `public` — it was previously package-private only because `PlayerStateDTO` happened to be in the same package. There is no encapsulation reason to restrict it.

## Adding a New State Object

No central registry needs updating. Simply:

1. Create the domain class implementing `Persistable`
2. Create the DTO implementing `PersistableDTO` with `@AutoService(PersistableDTO.class)` and a `@MapsFrom(YourDomainClass.class)` constructor

The registry discovers and wires it automatically at startup.
