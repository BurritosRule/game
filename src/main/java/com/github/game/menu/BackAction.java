package com.github.game.menu;

import com.github.game.world.Action;

public class BackAction implements Action {
  private final MenuController menuController;

  public BackAction(MenuController menuController) {
    this.menuController = menuController;
  }

  @Override
  public String getKeyword() {
    return "back";
  }

  @Override
  public void execute() {
    menuController.removeLastMenu();

  }
}
