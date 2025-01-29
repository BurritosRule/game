package com.github.game.world;

public class LocationChangedEvent {
  private final LocationName newLocationName;

  public LocationChangedEvent(LocationName newLocationName) {
    this.newLocationName = newLocationName;
  }

  public LocationName getNewLocationName() {
    return newLocationName;
  }
}