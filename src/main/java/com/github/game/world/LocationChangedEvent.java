package com.github.game.world;

public class LocationChangedEvent {
  private final LocationName newLocationName;

  public LocationChangedEvent(LocationName newLocationName) {
    this.newLocationName = newLocationName;
  }

  public LocationName getNewLocationName() {
    return newLocationName;
  }

  /**
   * Helper to update PlayerState and post LocationChangedEvent for all location
   * changes.
   * Always use this when changing player location.
   */
  public static void updatePlayerLocationAndPost(LocationName newLocationName) {
    // Update PlayerState
    com.github.game.player.PlayerState playerState = (com.github.game.player.PlayerState) com.github.game.state.GameState
        .getInstance().getState("PlayerState");
    if (playerState != null) {
      playerState.setCurrentLocation(newLocationName);
    }
    // Post event
    com.github.game.world.EventBusSingleton.getInstance().post(new LocationChangedEvent(newLocationName));
  }
}