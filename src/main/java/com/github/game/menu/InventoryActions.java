package com.github.game.menu;

import java.util.ArrayList;
import java.util.List;

import com.github.game.world.Action;

public class InventoryActions {
  public List<Action> getActions() {

    List<Action> actions = new ArrayList<Action>();

    actions.add(new Action() {

      @Override
      public String getKeyword() {
        return "item";
      }

      @Override
      public void execute() {
        System.exit(0);

      }
    });
    return actions;

  }
}
