package com.github.game.menu;

import com.github.game.player.Player;
import com.github.game.world.Action;
import com.github.game.world.EventBusSingleton;
import com.github.game.world.Location;
import com.github.game.world.LocationChangedEvent;
import com.github.game.world.LocationName;
import com.github.game.world.World;

public class UmbrusMenuActions implements Action {
  private final MenuController menuController;
  private final MenuFactory menuFactory;
  private final World world;
  private final Player player;

  public UmbrusMenuActions(MenuController menuController, MenuFactory menuFactory, World world, Player player) {
    this.menuController = menuController;
    this.menuFactory = menuFactory;
    this.world = world;
    this.player = player;
  }

  @Override
  public String getKeyword() {
    return "leave town";
  }

  @Override
  public void execute() {
    menuController.clearMenu();
    Location windingPath = world.getLocation(LocationName.WINDING_PATH);
    player.setCurrentLocation(windingPath);
    Menu windingPathMenu = menuFactory.getMenu(windingPath);
    menuController.addMenu(windingPathMenu);
    EventBusSingleton.getInstance().post(new LocationChangedEvent(LocationName.WINDING_PATH));
  }

}
