package com.github.game.menu;

import com.github.game.world.Action;

public class InventoryMenuAction implements Action {
  private final MenuController menuController;
  private final MenuFactory menuFactory;

  public InventoryMenuAction(MenuController menuController, MenuFactory menuFactory) {
    this.menuController = menuController;
    this.menuFactory = menuFactory;
  }

  @Override
  public String getKeyword() {
    return "inventory";
  }

  @Override
  public void execute() {
    Menu inventoryMenu = menuFactory.createInventoryMenu();
    menuController.addMenu(inventoryMenu);
  }

}
