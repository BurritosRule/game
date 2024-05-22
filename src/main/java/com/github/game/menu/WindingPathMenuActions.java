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

  }
}
