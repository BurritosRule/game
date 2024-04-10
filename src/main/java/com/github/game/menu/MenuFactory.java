package com.github.game.menu;

import com.github.game.player.Player;
import com.github.game.world.Location;
import com.github.game.world.Tower;
import com.github.game.world.Umbrus;

public class MenuFactory {
  private final MenuController menuController;
  private final Player player;

  public MenuFactory(MenuController menuController, Player player) {
    this.menuController = menuController;
    this.player = player;
  }

  public Menu getMenu(Location location) {

    if (location instanceof Tower) {
      return new TowerMenu((Tower) location, menuController, this);
    }

    if (location instanceof Umbrus) {
      return new UmbrusMenu(new UmbrusMenuActions(menuController, this));
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
