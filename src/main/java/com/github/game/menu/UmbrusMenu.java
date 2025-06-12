package com.github.game.menu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.github.game.world.Action;

public class UmbrusMenu implements TownMenu {
  public String header;
  private final UmbrusMenuActions umbrusMenuActions;
  private Collection<Action> additionalActions;

  private List<Action> possibleInput = new ArrayList<Action>();

  public UmbrusMenu(UmbrusMenuActions umbrusMenuActions) {
    this.header = "Umbrus Menu\n----------------------";
    this.umbrusMenuActions = umbrusMenuActions;
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
    possibleInput.clear();
    possibleInput.add(umbrusMenuActions);
    if (additionalActions != null && additionalActions.size() > 0) {
      possibleInput.addAll(additionalActions);
    }
    return possibleInput;
  }

}
