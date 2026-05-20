package com.github.game.world;

import com.github.game.state.GameState;

public class LocationFactory {

  private final GameState gameState;
  private final DomainEventPublisher publisher;

  public LocationFactory(GameState gameState, DomainEventPublisher publisher) {
    this.gameState = gameState;
    this.publisher = publisher;
  }

  public Location createLocation(LocationName locationName) {

    if (locationName == LocationName.WINDING_PATH) {
      ChestState chestState = (ChestState) gameState.getStateObject("winding_path_chest_1");
      if (chestState == null) {
        chestState = new ChestState();
        gameState.addStateObject("winding_path_chest_1", chestState);
      }
      chestState.setPublisher(publisher);
      return new WindingPath(chestState);
    }

    if (locationName == LocationName.UMBRUS) {
      return new Umbrus();
    }

    throw new IllegalArgumentException("Unrecognized location name: " + locationName);

  }
}
