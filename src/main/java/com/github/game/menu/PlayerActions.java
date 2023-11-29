package com.github.game.menu;

import com.github.game.world.Action;

public class PlayerActions implements Action {
  private final MenuOrchestrator menuOrchestrator;

  public PlayerActions(MenuOrchestrator menuOrchestrator) {
    this.menuOrchestrator = menuOrchestrator;
  }

  @Override
  public String getKeyword() {
    return "inventory";
  }

  @Override
  public void execute() {
    menuOrchestrator.addInventoryMenu();
  }
}
