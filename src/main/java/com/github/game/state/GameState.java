package com.github.game.state;

import com.github.game.world.EventBusSingleton;
import java.util.HashMap;
import java.util.Map;

public class GameState {
  private static volatile GameState instance;
  // Map of identifier -> Object (was Persistable)
  private final Map<String, Object> stateMap = new HashMap<>();

  private GameState() {
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

  @com.google.common.eventbus.Subscribe
  public void handleStateChange(com.github.game.world.StateChangedEvent event) {
    stateMap.put(event.getIdentifier(), event.getPersistable());
  }

  public Object getState(String identifier) {
    return stateMap.get(identifier);
  }

  public void setState(String identifier, Object obj) {
    stateMap.put(identifier, obj);
  }

  public java.util.Map<String, Object> getAllState() {
    return stateMap;
  }
}