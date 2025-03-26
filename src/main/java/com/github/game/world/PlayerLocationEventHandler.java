package com.github.game.world;

import com.github.game.state.GameState;
import com.google.common.eventbus.Subscribe;

public class PlayerLocationEventHandler {
  public PlayerLocationEventHandler() {
    EventBusSingleton.getInstance().register(this);
  }

  @Subscribe
  public void handleLocationChange(LocationChangedEvent event) {
    GameState.getInstance().setPlayerLocation(event.getNewLocationName());
  }
}
