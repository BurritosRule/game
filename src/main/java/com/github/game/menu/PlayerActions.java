package com.github.game.menu;

import com.github.game.world.Action;

public class PlayerActions implements Action {
  private final MenuController menuController;
  private final MenuFactory menuFactory;
  private final MenuUpdater menuUpdater;

  public PlayerActions(MenuController menuController, MenuFactory menuFactory, MenuUpdater menuUpdater) {
    this.menuController = menuController;
    this.menuFactory = menuFactory;
    this.menuUpdater = menuUpdater;
  }

  @Override
  public String getKeyword() {
    return "inventory";
  }

  @Override
  public void execute() {
    Menu inventoryMenu = menuFactory.createInventoryMenu();
    menuController.addMenu(inventoryMenu);
    menuUpdater.updateMenu(inventoryMenu);
  }
}
