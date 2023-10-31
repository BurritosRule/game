package com.github.game.menu;

public class MenuUpdater {

  private MenuController menuController;

  public MenuUpdater(MenuController menuController) {

    this.menuController = menuController;
  }

  public void updateMenu(Menu menu) {
    if (menuController.isBackEnabled()) {
      menu.addActions(new BackAction().getActions(menuController));
    }
  }

}
