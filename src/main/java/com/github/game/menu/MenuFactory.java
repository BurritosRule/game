package com.github.game.menu;

import com.github.game.world.Location;
import com.github.game.world.TowerImpl;

public class MenuFactory {
	public Menu getMenu(Location location) {
		if (location == null) {
			return null;
		}

		if (location instanceof TowerImpl) {
			return new TowerMenu();
		}

		return null;

	}
}
