package com.github.game.menu;

import com.github.game.world.Action;

public class InventoryActions implements Action {

  @Override
  public String getKeyword() {
    return "item";
  }

  @Override
  public void execute() {
    System.exit(0);

  }
}
