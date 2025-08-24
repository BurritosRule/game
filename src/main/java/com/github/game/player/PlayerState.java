package com.github.game.player;

import com.github.game.state.GameState;
import com.github.game.world.Location;
import com.github.game.world.LocationName;
import com.github.game.world.Persistable;

public class PlayerState implements Persistable {
  private LocationName currentLocation;

  public PlayerState(LocationName initialLocation) {
    this.currentLocation = initialLocation;
    GameState.getInstance().setState(getIdentifier(), this);
  }

  public LocationName getCurrentLocation() {
    return currentLocation;
  }

  public void setCurrentLocation(LocationName location) {
    this.currentLocation = location;
  }

  @Override
  public String getIdentifier() {
    return "PlayerLocation";
  }

  @Override
  public String serialize() {
    return currentLocation.name();
  }

  @Override
  public void deserialize(String data) {
    if (data != null && !data.isEmpty()) {
      this.currentLocation = LocationName.valueOf(data);
    }
  }
}
