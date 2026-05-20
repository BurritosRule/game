package com.github.game.state;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GameState {
  private static volatile GameState instance;
  private final Map<String, Persistable> stateObjects;

  private GameState() {
    this.stateObjects = new ConcurrentHashMap<>();
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

  public void replaceAll(Map<String, Persistable> newStates) {
    stateObjects.clear();
    stateObjects.putAll(newStates);
  }
}