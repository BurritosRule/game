package com.github.game.menu;

import com.github.game.world.Action;

public class OptionActions implements Action {

  @Override
  public String getKeyword() {
    return "quit";
  }

  @Override
  public void execute() {
    System.exit(0);

  }
}
