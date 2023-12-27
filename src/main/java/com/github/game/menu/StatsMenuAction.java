package com.github.game.menu;

import com.github.game.world.Action;

public class StatsMenuAction implements Action {
  private final MenuController menuController;
  private final MenuFactory menuFactory;

  public StatsMenuAction(MenuController menuController, MenuFactory menuFactory) {
    this.menuController = menuController;
    this.menuFactory = menuFactory;
  }

  @Override
  public String getKeyword() {
    return "stats";
  }

  @Override
  public void execute() {
    Menu statsMenu = menuFactory.createStatsMenu();
    menuController.addMenu(statsMenu);
  }

}
