package com.github.game.menu;

import java.util.List;

public class MenuUpdater {

  private MenuController menuController;

  public MenuUpdater(MenuController menuController) {

    this.menuController = menuController;
  }

  public void addBackAction(Menu menu) {

  }

  public void updateMenu(Menu menu) {
    if (menuController.isBackEnabled()) {
      menu.addActions(List.of(new BackAction()));
    }

    if (menu instanceof TowerMenu) {
      menu.addActions(List.of(new PlayerActions()));
      menu.addActions(List.of(new OptionActions()));
    }
  }

}
