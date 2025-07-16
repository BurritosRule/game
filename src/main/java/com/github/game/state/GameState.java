package com.github.game.state;

import com.github.game.world.EventBusSingleton;
import com.github.game.world.StateChangedEvent;
import com.github.game.world.Persistable;
import com.google.common.eventbus.Subscribe;
import java.util.HashMap;
import java.util.Map;

public class GameState {
  private static volatile GameState instance;
  // Map of identifier -> Persistable
  private final Map<String, Persistable> stateMap = new HashMap<>();

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

  @Subscribe
  public void handleStateChange(StateChangedEvent event) {
    stateMap.put(event.getIdentifier(), event.getPersistable());
  }

  public Persistable getState(String identifier) {
    return stateMap.get(identifier);
  }

  public void setState(String identifier, Persistable persistable) {
    stateMap.put(identifier, persistable);
  }

  public Map<String, Persistable> getAllState() {
    return stateMap;
  }
}