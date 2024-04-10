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
    return "leave";
  }

  @Override
  public void execute() {
    // Clear the menu deque
    // Add menu for next location (some kind of path?)
    Menu statsMenu = menuFactory.createStatsMenu();
    menuController.addMenu(statsMenu);
  }

}
