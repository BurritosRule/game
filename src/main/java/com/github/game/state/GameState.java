package com.github.game.state;

import com.github.game.world.LocationName;

public class GameState {
  private static GameState instance;
  private LocationName playerLocation;

  private GameState() {
    this.playerLocation = LocationName.UMBRUS; // Default location
  }

  public static GameState getInstance() {
    if (instance == null) {
      synchronized (GameState.class) {
        if (instance == null) {
          instance = new GameState();
        }
      }
    }
    return instance;
  }

  public LocationName getPlayerLocation() {
    return playerLocation;
  }

  public void setPlayerLocation(LocationName playerLocation) {
    this.playerLocation = playerLocation;
  }
}