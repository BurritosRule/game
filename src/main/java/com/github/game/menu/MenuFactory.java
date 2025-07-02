package com.github.game.menu;

import com.github.game.player.Player;
import com.github.game.world.Location;
import com.github.game.world.Tower;
import com.github.game.world.Umbrus;
import com.github.game.world.WindingPath;
import com.github.game.world.World;

public class MenuFactory {
  private final MenuController menuController;
  private final Player player;
  private final World world;

  public MenuFactory(MenuController menuController, Player player, World world) {
    this.menuController = menuController;
    this.player = player;
    this.world = world;
  }

  public Menu getMenu(Location location) {

    if (location instanceof Tower) {
      return new TowerMenu((Tower) location, menuController, this);
    }

    if (location instanceof Umbrus) {
      return new UmbrusMenu(new UmbrusMenuActions(menuController, this, world));
    }

    if (location instanceof WindingPath) {
      WindingPathMenu menu = new WindingPathMenu((WindingPath) location);
      // Inject the location-specific action (continue to tower) using addActions
      menu.addActions(java.util.List.of(new WindingPathMenuActions(menuController)));
      return menu;
    }

    throw new IllegalArgumentException("Unrecognized location type: " + location);

  }

  public Menu createInventoryMenu() {
    return new InventoryMenu(new InventoryActions());
  }

  public Menu createStatsMenu() {
    return new StatsMenu(player);
  }
}
