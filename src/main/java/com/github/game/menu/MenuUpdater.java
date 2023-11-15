package com.github.game.menu;

import java.util.List;

public class MenuUpdater {

  private MenuController menuController;

  public MenuUpdater(MenuController menuController) {

    this.menuController = menuController;
  }

  public void updateMenu(Menu menu) {
    if (menuController.isBackEnabled()) {
      menu.addActions(List.of(new BackAction(menuController)));
    }

    if (menu instanceof TowerMenu) {
      menu.addActions(List.of(new PlayerActions()));
      menu.addActions(List.of(new OptionActions()));
    }
  }

}
