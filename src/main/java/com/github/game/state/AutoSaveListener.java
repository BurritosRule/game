package com.github.game.state;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.github.game.world.ChestStateChangedEvent;
import com.github.game.world.LocationChangedEvent;

public class AutoSaveListener {
  private final GameStatePersistence persistence;
  private final GameState gameState;
  private final String saveFile;

  public AutoSaveListener(EventBus eventBus, GameStatePersistence persistence, GameState gameState, String saveFile) {
    this.persistence = persistence;
    this.gameState = gameState;
    this.saveFile = saveFile;
    eventBus.register(this);
  }

  @Subscribe
  public void onChestStateChanged(ChestStateChangedEvent event) {
    persistence.save(gameState, saveFile);
  }

  @Subscribe
  public void onLocationChanged(LocationChangedEvent event) {
    persistence.save(gameState, saveFile);
  }
}
