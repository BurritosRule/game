package com.github.game.world;

public class LocationFactory {

  // Make location a constant or enum instead of string?
  public Location createLocation(String location) {

    if ("WindingPath".equals(location)) {
      return new WindingPath();
    }

    throw new IllegalArgumentException("Unrecognized location type: " + location);

  }
}
