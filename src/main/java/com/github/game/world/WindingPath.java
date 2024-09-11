package com.github.game.world;

import java.util.ArrayList;
import java.util.List;

public class WindingPath implements Path {

  private final Chest chest = new Chest();
  @Override
  public List<Action> getActions() {
    List<Action> actions = new ArrayList<Action>();

    actions.add(new Action() {
      // TODO Refactor UI concern out of this class
      @Override
      public String getKeyword() {
        return "description";
      }

      @Override
      public void execute() {
        WindingPath.this.getDescription();
      }
    });

    actions.addAll(chest.getActions());

    return actions;
  }

  @Override
  public String getName() {
    return "Winding Path";
  }

  @Override
  public String getSubLocation() {
    return "sub location";
  }

  @Override
  public String getDescription() {
    return "This is a path\n";
  }

}
