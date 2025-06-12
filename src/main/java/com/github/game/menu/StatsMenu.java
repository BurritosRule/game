package com.github.game.menu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.github.game.player.Player;
import com.github.game.world.Action;

public class StatsMenu implements Menu {
  public String header;
  private Collection<Action> additionalActions;

  private List<Action> possibleInput = new ArrayList<Action>();

  public StatsMenu(Player player) {
    this.header = "Stats Menu\n----------------------\n\nAttack: " + player.getAttack() + "\nDefense: "
        + player.getDefense();
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
    if (additionalActions != null && additionalActions.size() > 0) {
      possibleInput.addAll(additionalActions);
    }
    return possibleInput;
  }
}
