package com.github.game.menu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.github.game.world.Action;
import com.github.game.world.WindingPath;

public class WindingPathMenu implements PathMenu {
  private final WindingPath windingPath;
  public String header;
  private final List<Action> additionalActions = new ArrayList<>();

  public WindingPathMenu(WindingPath windingPath) {
    this.header = "Winding Path Menu\n----------------------";
    this.windingPath = windingPath;
  }

  // Use this for any injected actions (location-specific or global)
  @Override
  public void addActions(Collection<Action> actions) {
    if (actions != null) {
      additionalActions.addAll(actions);
    }
  }

  @Override
  public String header() {
    return header;
  }

  @Override
  public List<Action> possibleInput() {
    List<Action> possibleInput = new ArrayList<>();
    possibleInput.addAll(windingPath.getActions());
    possibleInput.addAll(additionalActions);
    return possibleInput;
  }
}
