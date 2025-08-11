package com.github.game.world;

import java.util.HashMap;

public class World {
  private final LocationFactory locationFactory;

  public World(LocationFactory locationFactory) {
    this.locationFactory = locationFactory;
  }

  HashMap<LocationName, Location> locations = new HashMap<>();

  public Location getLocation(LocationName locationName) {
    // For persistable locations, check GameState first
    if (locationName == LocationName.WINDING_PATH) {
      Object loaded = com.github.game.state.GameState.getInstance().getState("WindingPath");
      if (loaded instanceof Location) {
        locations.put(locationName, (Location) loaded);
        return (Location) loaded;
      }
    }
    if (!locations.containsKey(locationName)) {
      locations.put(locationName, locationFactory.createLocation(locationName));
    }
    return locations.get(locationName);
  }
}
