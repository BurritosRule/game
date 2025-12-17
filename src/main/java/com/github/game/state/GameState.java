package com.github.game.state;

import com.github.game.world.ChestStateChangedEvent;
import com.github.game.world.EventBusSingleton;
import com.github.game.world.LocationChangedEvent;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import com.google.common.eventbus.Subscribe;

public class GameState {
  private static volatile GameState instance;
  private final Map<String, Persistable> stateObjects;

  private GameState() {
    this.stateObjects = new ConcurrentHashMap<>();
    EventBusSingleton.getInstance().register(this);
  }

  public static GameState getInstance() {
    if (instance == null) {
      synchronized (GameState.class) {
        if (instance == null) {
          instance = new GameState();
        }
      }
    }
    return instance;
  }

  public void addStateObject(String key, Persistable stateObject) {
    stateObjects.put(key, stateObject);
  }

  public Persistable getStateObject(String key) {
    return stateObjects.get(key);
  }

  public void removeStateObject(String key) {
    stateObjects.remove(key);
  }

  public Map<String, Persistable> getAllStateObjects() {
    return stateObjects;
  }

  // Example event handling: update state objects as needed
  @Subscribe
  public void handleLocationChange(LocationChangedEvent event) {
    // Event handler - can trigger auto-save if needed
    // For now, just log the event
    System.out.println("Location changed to: " + event.getNewLocationName());
  }

  @Subscribe
  public void handleChestStateChange(ChestStateChangedEvent event) {
    // Event handler - can trigger auto-save if needed
    System.out.println("Chest state changed: " + event.getNewState());
    // Example: Auto-save on chest state change
    // GameStatePersistence.saveToFile(this, "savegame.json");
  }
}