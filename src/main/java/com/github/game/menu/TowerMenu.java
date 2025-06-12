package com.github.game.menu;

import java.util.Collection;
import java.util.List;

import com.github.game.world.Action;
import com.github.game.world.Tower;

public class TowerMenu implements Menu {

  private final Tower tower;
  private Collection<Action> additionalActions;
  private final String header;
  private final MenuController menuController;
  private final MenuFactory menuFactory;

  public TowerMenu(Tower tower, MenuController menuController, MenuFactory menuFactory) {
    this.tower = tower;
    this.header = "Tower Menu\n----------------------";
    this.menuController = menuController;
    this.menuFactory = menuFactory;
  }

  @Override
  public void addActions(Collection<Action> additionalActions) {
    this.additionalActions = additionalActions;

  }

  @Override
  public List<Action> possibleInput() {
    List<Action> possibleInput = tower.getActions();
    if (!tower.canDescend()) {
      possibleInput.add(new ExitLocationAction(menuController));
    }
    possibleInput.add(new InventoryMenuAction(menuController, menuFactory));
    possibleInput.add(new StatsMenuAction(menuController, menuFactory));
    if (additionalActions != null) {
      possibleInput.addAll(additionalActions);
    }
    return possibleInput;
  }

  @Override
  public String header() {
    return header;
  }

}
