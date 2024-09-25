package com.github.game.world;

public class LocationFactory {

  public Location createLocation(LocationName locationName) {

    if (locationName == LocationName.WINDING_PATH) {
      return new WindingPath();
    }

    throw new IllegalArgumentException("Unrecognized location name: " + locationName);

  }
}
