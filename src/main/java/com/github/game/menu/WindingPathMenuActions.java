package com.github.game.menu;

import com.github.game.world.Action;
import com.github.game.world.EventBusSingleton;
import com.github.game.world.LocationChangedEvent;
import com.github.game.world.LocationName;

public class WindingPathMenuActions implements Action {
  private final MenuController menuController;
  private final MenuFactory menuFactory;

  public WindingPathMenuActions(MenuController menuController, MenuFactory menuFactory) {
    this.menuController = menuController;
    this.menuFactory = menuFactory;
  }

  @Override
  public String getKeyword() {
    return "continue to tower";
  }

  @Override
  public void execute() {
    menuController.clearMenu();
    // Get the tower location from the world and use the menu factory to create the
    // menu
    com.github.game.world.Tower tower = new com.github.game.world.TowerImpl("Castle Tower", 10);
    Menu towerMenu = new TowerMenu(tower, menuController, menuFactory);
    menuController.addMenu(towerMenu);
    EventBusSingleton.getInstance().post(new LocationChangedEvent(LocationName.TOWER));
  }
}
