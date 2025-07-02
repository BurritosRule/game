package com.github.game.menu;

import com.github.game.world.Action;

public class WindingPathMenuActions implements Action {
  private final MenuController menuController;

  public WindingPathMenuActions(MenuController menuController) {
    this.menuController = menuController;
  }

  @Override
  public String getKeyword() {
    return "continue to tower";
  }

  @Override
  public void execute() {
    System.out.println("You continue to the tower (not yet implemented)");
    // In the future, transition to the tower menu here
  }
}
