package com.github.game.state;

import com.google.common.eventbus.Subscribe;

public class AutoSaveListener {
  private final String saveFile;

  public AutoSaveListener(String saveFile) {
    this.saveFile = saveFile;
  }

  @Subscribe
  public void onAnyEvent(Object event) {
    GameStatePersistence.saveToFile(GameState.getInstance(), saveFile);
  }
}
