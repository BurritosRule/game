package com.github.game.menu;

import com.github.game.world.Action;

public class BackAction implements Action {
  // private final MenuController menuController;

  // public BackAction(MenuController menuController) {
  //   this.menuController = menuController;
  // }

    private final MenuOrchestrator menuOrchestrator;

  public BackAction(MenuOrchestrator menuOrchestrator) {
    this.menuOrchestrator = menuOrchestrator;
  }

  @Override
  public String getKeyword() {
    return "back";
  }

  @Override
  public void execute() {
    menuOrchestrator.getMenuController().removeLastMenu();
  }
}
