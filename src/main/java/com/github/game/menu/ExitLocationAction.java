package com.github.game.menu;

import com.github.game.world.Action;

public class ExitLocationAction implements Action {

  private final MenuController menuController;

  public ExitLocationAction(MenuController menuController) {
    this.menuController = menuController;
  }

  @Override
  public String getKeyword() {
    return "exit location";
  }

  @Override
  public void execute() {
    menuController.clearMenu();

  }
}
