package com.github.game.menu;

import com.github.game.world.Action;

public class WindingPathMenuActions implements Action {
  private final MenuController menuController;
  private final MenuFactory menuFactory;

  public WindingPathMenuActions(MenuController menuController, MenuFactory menuFactory) {
    this.menuController = menuController;
    this.menuFactory = menuFactory;
  }

  @Override
  public String getKeyword() {
    return "continue to tower";
  }

  @Override
  public void execute() {
    menuController.clearMenu();
    // TODO: update player location when moving to Tower (player.setCurrentLocation)
    com.github.game.world.Tower tower = new com.github.game.world.TowerImpl("Castle Tower", 10);
    Menu towerMenu = new TowerMenu(tower, menuController, menuFactory);
    menuController.addMenu(towerMenu);
  }
}
