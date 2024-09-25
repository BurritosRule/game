package com.github.game.world;

import java.util.HashMap;

public class World {
  private final LocationFactory locationFactory;

  public World(LocationFactory locationFactory) {
    this.locationFactory = locationFactory;
  }

  HashMap<LocationName, Location> locations = new HashMap<>();

  public Location getLocation(LocationName locationName) {
    if (!locations.containsKey(locationName)) {
      locations.put(locationName, locationFactory.createLocation(locationName));
    }
    return locations.get(locationName);
  }
}
