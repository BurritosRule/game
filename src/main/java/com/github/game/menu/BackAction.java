package com.github.game.menu;

import java.util.ArrayList;
import java.util.List;

import com.github.game.world.Action;

public class BackAction {
  public List<Action> getActions(MenuController menuController) {

    List<Action> actions = new ArrayList<Action>();

    actions.add(new Action() {

      @Override
      public String getKeyword() {
        return "back";
      }

      @Override
      public void execute() {
        menuController.removeLastMenu();

      }
    });
    return actions;

  }
}
