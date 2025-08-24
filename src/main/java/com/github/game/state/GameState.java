package com.github.game.state;

import com.github.game.world.ChestStateChangedEvent;
import com.github.game.world.EventBusSingleton;
import com.github.game.world.LocationChangedEvent;
import com.github.game.world.LocationName;
import com.github.game.state.Persistable;
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
    // If you have a LocationState object, update it here
    Persistable locationState = stateObjects.get("playerLocation");
    if (locationState instanceof LocationName) {
      // Replace with new location
      stateObjects.put("playerLocation", event.getNewLocationName());
    }
  }

  @Subscribe
  public void handleChestStateChange(ChestStateChangedEvent event) {
    // Generic event handler: can trigger persistence or notify listeners
    // For example, auto-save game state when any chest state changes
    // GameStatePersistence.saveToFile(this, "savegame.txt");
    // Or simply log the event for now
    System.out.println("Chest state changed: " + event.getNewState());
    // No direct manipulation of state objects here
  }
}