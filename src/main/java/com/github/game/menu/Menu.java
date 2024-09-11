package com.github.game.menu;

import java.util.Collection;
import java.util.List;

import com.github.game.world.Action;

public interface Menu {

  public String header();

  public List<Action> possibleInput();

  public void addActions(Collection<Action> additionalActions);

}
