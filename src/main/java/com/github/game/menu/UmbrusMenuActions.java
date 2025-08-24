package com.github.game.menu;

import com.github.game.world.Action;
import com.github.game.world.EventBusSingleton;
import com.github.game.world.LocationChangedEvent;
import com.github.game.world.LocationName;
import com.github.game.world.World;

public class UmbrusMenuActions implements Action {
  private final MenuController menuController;
  private final MenuFactory menuFactory;
  private final World world;

  public UmbrusMenuActions(MenuController menuController, MenuFactory menuFactory, World world) {
    this.menuController = menuController;
    this.menuFactory = menuFactory;
    this.world = world;
  }

  @Override
  public String getKeyword() {
    return "leave town";
  }

  @Override
  public void execute() {
    menuController.clearMenu();
    Menu windingPathMenu = menuFactory.getMenu(world.getLocation(LocationName.WINDING_PATH));
    menuController.addMenu(windingPathMenu);
    EventBusSingleton.getInstance().post(new LocationChangedEvent(LocationName.WINDING_PATH));
  }

}
