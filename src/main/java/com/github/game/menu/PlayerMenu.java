package com.github.game.menu;

import java.util.Collection;
import java.util.List;

import com.github.game.world.Action;

public class PlayerMenu implements Menu {

  public String header;
  private final PlayerActions playerActions;
  private Collection<Action> additionalActions;

  public PlayerMenu(PlayerActions playerActions) {

    this.header = "Player Menu\n----------------------";
    this.playerActions = playerActions;
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
    List<Action> possibleInput = playerActions.getActions();
    possibleInput.addAll(additionalActions);
    return possibleInput;
  }

}
