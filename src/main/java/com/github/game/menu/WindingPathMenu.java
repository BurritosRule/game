package com.github.game.menu;

import java.util.Collection;
import java.util.List;

import com.github.game.world.Action;
import com.github.game.world.WindingPath;

public class WindingPathMenu implements PathMenu {
  private final WindingPath windingPath;
  public String header;
  private Collection<Action> additionalActions;

  public WindingPathMenu(WindingPath windingPath) {
    this.header = "Winding Path Menu\n----------------------";
    this.windingPath = windingPath;
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
    List<Action> possibleInput = windingPath.getActions();
    if (additionalActions != null && additionalActions.size() > 0) {
      possibleInput.addAll(additionalActions);
    }

    return possibleInput;
  }
}
