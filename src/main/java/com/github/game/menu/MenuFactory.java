package com.github.game.menu;

import com.github.game.world.Location;
import com.github.game.world.Tower;

public class MenuFactory {
	public Menu getMenu(Location location) {

		if (location instanceof Tower) {
			return new TowerMenu((Tower) location, new OptionActions().getActions());
		}

		throw new IllegalArgumentException("Unrecognized location type: " + location);

	}

	public Menu getPlayerMenu() {
		return new PlayerMenu(new PlayerActions().getActions());
	}
}
