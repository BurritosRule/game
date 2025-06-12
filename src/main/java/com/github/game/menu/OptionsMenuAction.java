package com.github.game.menu;

import com.github.game.world.Action;

public class OptionsMenuAction implements Action {
  private final MenuController menuController;
  private final MenuFactory menuFactory;

  public OptionsMenuAction(MenuController menuController, MenuFactory menuFactory) {
    this.menuController = menuController;
    this.menuFactory = menuFactory;
  }

  @Override
  public String getKeyword() {
    return "options";
  }

  @Override
  public void execute() {
    Menu optionsMenu = new OptionsMenu(menuController);
    menuController.addMenu(optionsMenu);
  }
}
