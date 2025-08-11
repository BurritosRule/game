# Game State, Event Streaming, and Persistence Flow (WindingPath & Chest Example)

This document explains the end-to-end flow of event streaming, state management, and persistence in the game, using the `WindingPath` location and its nested `Chest` as a concrete example.

---

## 1. Object Structure & Registration

- **WindingPath** is a location in the game world. It contains a `Chest` as a field.
- On construction, `WindingPath` registers itself with the global `GameState` registry using a unique key (`"WindingPath"`).
- Only `WindingPath` is registered for persistence; the `Chest` is persisted as a nested field within `WindingPath`'s DTO.

---

## 2. State Management

- **GameState** is a singleton that holds a map of all persistable game objects, keyed by unique string IDs.
- When the game starts, `PersistableRegistry.registerAll(GameState.getInstance())` ensures all persistable objects (like `WindingPath`) are registered.
- The current state of each object (e.g., whether the chest is open or closed) is always accessed through the registered instance in `GameState`.

---

## 3. Event Streaming (Autosave)

- The `Chest` class posts a `ChestStateChangedEvent` to the global event bus whenever its state changes (e.g., when opened or closed).
- `AutoSaveListener` subscribes to these events. When it receives a `ChestStateChangedEvent`, it triggers a save of the game state.
- This ensures that any change to the chest (or other important game events) is immediately persisted.

---

## 4. Persistence (Save/Load)

- **Saving:**
  - `GamePersistence.saveGame()` iterates over all registered objects in `GameState`.
  - For each object implementing `GameSerializable<T>`, it calls `toDTO()` to get a serializable DTO.
  - For `WindingPath`, `toDTO()` creates a `WindingPathDTO` that includes the chest's state (via `ChestPersistenceAdapter.toDTO()`).
  - All DTOs are collected into a single `GameSaveDTO` and written to `savegame.json`.
  - The resulting save file contains a single entry for `WindingPath`, with the chest state nested inside.

- **Loading:**
  - On startup, `GamePersistence.loadGame()` reads `savegame.json` and deserializes it into a `GameSaveDTO`.
  - For each entry, it looks up the registered object in `GameState` and calls `fromDTO()` with the loaded DTO.
  - For `WindingPath`, `fromDTO()` uses `ChestPersistenceAdapter.fromDTO()` to restore the chest's state from the nested DTO.

---

## 5. Example: Chest State Change Flow

1. **Player opens the chest:**
    - `Chest.open()` sets the state to `"opened"` and posts a `ChestStateChangedEvent`.
2. **Event bus delivers the event to `AutoSaveListener`.**
3. **`AutoSaveListener` calls `GamePersistence.saveGame()`.**
4. **`GamePersistence.saveGame()` serializes all registered objects:**
    - `WindingPath.toDTO()` calls `ChestPersistenceAdapter.toDTO()` to include the chest's state.
    - The save file is updated with the new chest state nested under `WindingPath`.
5. **On next load, `GamePersistence.loadGame()` restores the chest's state via `WindingPath.fromDTO()`.**

---

## 6. Key Classes & Responsibilities

- **WindingPath**: Implements `GameSerializable<WindingPathDTO>`, owns the chest, and handles nested persistence.
- **Chest**: Contains game logic and posts events on state change.
- **ChestPersistenceAdapter**: Converts chest state to/from a DTO for persistence.
- **GameState**: Central registry for all persistable objects.
- **GamePersistence**: Handles unified save/load of all registered objects.
- **AutoSaveListener**: Listens for important events and triggers saves.

---

## 7. Example Save File Structure

```json
{
  "schema": "GameSaveV3",
  "entries": [
    {
      "id": "WindingPath",
      "type": "com.github.game.world.WindingPathDTO",
      "dto": {
        "chest": {
          "schema": "ChestV1",
          "chestId": "Chest",
          "opened": true
        }
      }
    },
    // ...other entries (e.g., PlayerState)...
  ]
}
```

---

This architecture ensures:
- All state is unified and extensible.
- Game logic and persistence are decoupled (SOLID).
- Autosave and event-driven persistence are robust and easy to extend.
