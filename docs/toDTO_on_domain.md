# Why `toDTO()` Must Live on the Domain Object

## The Problem

`GameStatePersistence` iterates over a `Map<String, Persistable>`. At that point it only knows
about the `Persistable` interface — it has no idea whether any given entry is a `ChestState`,
`PlayerState`, or anything else. To produce the right DTO for each one, it needs to dispatch to
the correct type.

`toDTO()` on the domain object is what enables that:

```java
gameState.getAllStateObjects().forEach((key, value) -> dtoObjects.put(key, value.toDTO()));
```

## The Alternative

Calling the DTO's copy constructor directly:

```java
new ChestStateDTO(chestState)
```

This requires knowing the concrete type at the call site, which `GameStatePersistence` doesn't
have. Without it, you need either `instanceof` chains or a mapper registry — both of which bring
back exactly the complexity we removed.

## The Accepted Tradeoff

`ChestState` has one outward dependency on `ChestStateDTO` (inner → outer, wrong direction in
hexagonal terms) in exchange for keeping `GameStatePersistence` a clean, type-agnostic loop.

The `toDomain()` direction stays clean because the DTO calling `new ChestState(...)` is outer →
inner (correct direction).

## Summary

> `toDTO()` on the domain class is the price of polymorphic dispatch without a registry.
