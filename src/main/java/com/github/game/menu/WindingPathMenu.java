package com.github.game.menu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.github.game.world.Action;

public class WindingPathMenu implements PathMenu{
  public String header;
  private final WindingPathMenuActions windingPathMenuActions;
  private Collection<Action> additionalActions;

  private List<Action> possibleInput = new ArrayList<Action>();

  public WindingPathMenu(WindingPathMenuActions windingPathMenuActions) {
    this.header = "Winding Path Menu\n----------------------";
    this.windingPathMenuActions = windingPathMenuActions;
  }

  @Override
  public void addActions(Collection<Action> additionalActions) {
    this.additionalActions = additionalActions;
  }

  @Override
  public String header() {
    return header;
  }

  @Override
  public List<Action> possibleInput() {
    possibleInput.add(windingPathMenuActions);
    if (additionalActions != null && additionalActions.size() > 0) {
      possibleInput.addAll(additionalActions);
    }

    return possibleInput;
  }
}
