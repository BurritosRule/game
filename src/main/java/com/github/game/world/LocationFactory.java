package com.github.game.world;

import com.github.game.state.DomainEventPublisher;

public class LocationFactory {

  private final DomainEventPublisher publisher;

  public LocationFactory(DomainEventPublisher publisher) {
    this.publisher = publisher;
  }

  public Location createLocation(LocationName locationName) {

    if (locationName == LocationName.WINDING_PATH) {
      return new WindingPath(publisher);
    }

    if (locationName == LocationName.UMBRUS) {
      return new Umbrus();
    }

    throw new IllegalArgumentException("Unrecognized location name: " + locationName);

  }
}
