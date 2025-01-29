package com.github.game.world;

import com.google.common.eventbus.Subscribe;

public class LocationEventHandler {
  public LocationEventHandler() {
    EventBusSingleton.getInstance().register(this);
  }

  @Subscribe
  public void handleLocationChange(LocationChangedEvent event) {
    // Code here to set the location state as event.getNewLocationName();
  }
}
