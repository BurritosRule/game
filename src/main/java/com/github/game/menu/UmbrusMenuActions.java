package com.github.game.menu;

import com.github.game.world.Action;

public class UmbrusMenuActions implements Action {
  private final MenuController menuController;
  private final MenuFactory menuFactory;

  public UmbrusMenuActions(MenuController menuController, MenuFactory menuFactory) {
    this.menuController = menuController;
    this.menuFactory = menuFactory;
  }

  @Override
  public String getKeyword() {
    return "leave town";
  }

  @Override
  public void execute() {
    menuController.clearMenu();
    Menu windingPathMenu = menuFactory.createWindingPathMenu();
    menuController.addMenu(windingPathMenu);
    // This action results in a new player location... need a playerController to setLocation?
  }

}
