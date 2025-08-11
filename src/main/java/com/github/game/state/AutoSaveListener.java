package com.github.game.state;

import com.github.game.world.LocationChangedEvent;
import com.github.game.world.EventBusSingleton;
import com.google.common.eventbus.Subscribe;

public class AutoSaveListener {
  private final String saveFile;

  public AutoSaveListener(String saveFile) {
    this.saveFile = saveFile;
    EventBusSingleton.getInstance().register(this);
  }

  @Subscribe
  public void onChestStateChanged(com.github.game.world.ChestStateChangedEvent event) {
    com.github.game.state.GamePersistence.saveGame();
  }

  @Subscribe
  public void onLocationChanged(LocationChangedEvent event) {
    com.github.game.player.PlayerState playerState = (com.github.game.player.PlayerState) com.github.game.state.GameState
        .getInstance().getState("PlayerState");
    if (playerState != null) {
      playerState.setCurrentLocation(event.getNewLocationName());
    }
    com.github.game.state.GamePersistence.saveGame();
    GameStatePersistence.saveToFile(GameState.getInstance(), saveFile);
  }

  // Add more @Subscribe methods for other events you want to autosave on

  // Example: Add autosave for Umbrus and Tower (customize event as needed)
  // @Subscribe
  // public void onUmbrusStateChanged(SomeUmbrusEvent event) {
  // com.github.game.world.Umbrus umbrus = (com.github.game.world.Umbrus)
  // com.github.game.state.GameState.getInstance().getState("Umbrus");
  // if (umbrus != null) {
  // com.github.game.world.UmbrusFilePersistence.saveUmbrusToFile(umbrus);
  // }
  // }
  // @Subscribe
  // public void onTowerStateChanged(SomeTowerEvent event) {
  // com.github.game.world.TowerImpl tower = ...;
  // com.github.game.world.TowerFilePersistence.saveTowerToFile(tower);
  // }
}
