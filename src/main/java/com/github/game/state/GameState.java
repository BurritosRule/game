package com.github.game.state;

import com.github.game.world.ChestStateChangedEvent;
import com.github.game.world.EventBusSingleton;
import com.github.game.world.LocationChangedEvent;
import com.github.game.world.LocationName;
import com.google.common.eventbus.Subscribe;

public class GameState {
  private static volatile GameState instance;
  private LocationName playerLocation;
  private String chestState;

  private GameState() {
    this.playerLocation = LocationName.UMBRUS; // Default location
    EventBusSingleton.getInstance().register(this);
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

  @Subscribe
  public void handleLocationChange(LocationChangedEvent event) {
    setPlayerLocation(event.getNewLocationName());
  }

  public LocationName getPlayerLocation() {
    return playerLocation;
  }

  public void setPlayerLocation(LocationName playerLocation) {
    this.playerLocation = playerLocation;
  }

  @Subscribe
  public void handleChestStateChange(ChestStateChangedEvent event) {
    setChestState(event.getNewState());
  }

  public void setChestState(String chestState) {
    this.chestState = chestState;
  }

  public String getChestState() {
    return chestState;
  }
}