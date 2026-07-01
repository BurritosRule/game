# Domain Event Collection

## What it is

Domain Event Collection is a pattern where state objects record what happened internally,
and behavior objects are responsible for forwarding those events to the outside world.
The state object has zero knowledge of publishers, listeners, or infrastructure.

## The three roles

### 1. The aggregate (state object) — collects events

`ChestState` and `PlayerState` own a private `List<Object> domainEvents`. When a meaningful
state change occurs inside `setState()` or `setLocationName()`, they append an event to that
internal list. Nothing is fired outward. They have no knowledge of what will happen to those events.

```java
public void setState(ChestStateType state) {
    if (state != this.state) {
        this.state = state;
        domainEvents.add(new ChestStateChangedEvent(state.name())); // collected, not dispatched
    }
}
```

### 2. The behavior object — pulls and dispatches

`Chest` and `PlayerImpl` are the only things that mutate their respective state objects.
After each mutation, they call `pullDomainEvents()` to drain the list and forward whatever
came back to the publisher. They don't construct events — they act as the courier between
the state object and the outside world.

```java
// Chest.execute()
chestState.setState(ChestStateType.OPENED);
chestState.pullDomainEvents().forEach(publisher::publish);
```

`pullDomainEvents()` returns the collected list and clears it — like draining a queue.
If the state didn't change (chest was already open), the list is empty and nothing fires.

### 3. The publisher — routes to listeners

`EventBusPublisher` receives the events and posts them to the EventBus.
`AutoSaveListener` is subscribed and triggers a save on any event.

## The full flow for "open chest"

```
player types "open chest"
    → Chest.execute()
        → chestState.setState(OPENED)         // state changes, ChestStateChangedEvent added to list
        → chestState.pullDomainEvents()        // drains the list, returns [ChestStateChangedEvent]
        → publisher.publish(event)             // EventBusPublisher posts to EventBus
            → AutoSaveListener.onAnyEvent()    // saves to disk
```

## Why not inject the publisher directly into the state object?

Injecting a publisher into `ChestState` means the state object depends on an infrastructure
port. This creates two problems:

1. **Deserialization** — when `ChestState` is loaded from disk, it has no publisher.
   You end up needing fake/no-op constructors just to satisfy the dependency.

2. **Testing** — you can't instantiate `ChestState` in isolation without providing
   a publisher, even if the test has nothing to do with event publishing.

With Domain Event Collection, `ChestState` is pure data. It can be constructed, deserialized,
and tested with no wiring at all.

## Scaling to new state objects

Adding a new stateful object follows the same pattern:

1. Add `List<Object> domainEvents` to the state class
2. Append events in mutator methods instead of publishing them
3. Add `pullDomainEvents()` to drain the list
4. Give the behavior object a `DomainEventPublisher` and pull/dispatch after mutations

`AutoSaveListener` requires no changes — it subscribes to `Object` and handles any event.
