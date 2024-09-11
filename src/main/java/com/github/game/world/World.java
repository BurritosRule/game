package com.github.game.world;

import java.util.HashMap;

public class World {
  private final LocationFactory locationFactory;

  public World(LocationFactory locationFactory) {
    this.locationFactory = locationFactory;
  }

  HashMap<String, Location> locations = new HashMap<>();

  public void createWorld() {
    locations.put("WindingPath", locationFactory.createLocation("WindingPath"));
  }

  public Location getLocation(String location) {
    return locations.get(location);
  }
}
