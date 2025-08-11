package com.github.game.menu;

import com.github.game.world.Action;
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
    if (windingPathMenu == null) {
      System.err.println("Error: Could not create Winding Path menu. Menu is null.");
      return;
    }
    menuController.addMenu(windingPathMenu);
    // Use helper to update PlayerState and post event
    com.github.game.world.LocationChangedEvent.updatePlayerLocationAndPost(LocationName.WINDING_PATH);
  }

}
