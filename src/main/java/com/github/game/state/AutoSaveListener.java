package com.github.game.state;

import com.github.game.world.ChestStateChangedEvent;
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
  public void onChestStateChanged(ChestStateChangedEvent event) {
    GameStatePersistence.saveToFile(GameState.getInstance(), saveFile);
  }

  @Subscribe
  public void onLocationChanged(LocationChangedEvent event) {
    GameStatePersistence.saveToFile(GameState.getInstance(), saveFile);
  }

  // Add more @Subscribe methods for other events you want to autosave on
}
