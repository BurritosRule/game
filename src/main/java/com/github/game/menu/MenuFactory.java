package com.github.game.menu;

import com.github.game.world.TowerImpl;

public class MenuFactory {
	public Menu getMenu(TowerImpl tower) {
		if (tower == null) {
			return null;
		}

		if (tower instanceof TowerImpl) {
			return new TowerMenu();
		}

		return null;

	}
}
