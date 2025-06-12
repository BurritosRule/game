package com.github.game.menu;

import com.github.game.world.Action;
import java.util.ArrayList;
import java.util.List;

public class OptionsMenu implements Menu {
  private final List<Action> actions = new ArrayList<>();
  private final String header = "Options\n----------------------";

  public OptionsMenu(MenuController menuController) {
    actions.add(new ExitGameAction());
    actions.add(new BackAction(menuController));
  }

  @Override
  public String header() {
    return header;
  }

  @Override
  public List<Action> possibleInput() {
    return actions;
  }

  @Override
  public void addActions(java.util.Collection<Action> additionalActions) {
    // No-op for options menu
  }
}

class ExitGameAction implements Action {
  @Override
  public String getKeyword() {
    return "exit game";
  }

  @Override
  public void execute() {
    System.exit(0);
  }
}
