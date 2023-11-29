package com.github.game.menu;

public class MenuOrchestrator {

  private MenuController menuController;
  private MenuFactory menuFactory;
  private MenuUpdater menuUpdater;

  public MenuOrchestrator(MenuController menuController, MenuFactory menuFactory, MenuUpdater menuUpdater) {

    this.menuController = menuController;
    this.menuFactory = menuFactory;
    this.menuUpdater = menuUpdater;

  }

  public boolean isBackEnabled(MenuController menuController) {
    return menuController.isBackEnabled();
  }

  public void removeLastMenu() {
    menuController.removeLastMenu();
  }

  public void addInventoryMenu() {
    Menu inventoryMenu = menuFactory.createInventoryMenu();
    menuController.addMenu(inventoryMenu);
    if (isBackEnabled(menuController)) {
      menuUpdater.addBackAction(inventoryMenu);
    }
  }

  public MenuController getMenuController() {
    return menuController;
  }

}
