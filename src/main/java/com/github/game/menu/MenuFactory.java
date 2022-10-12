package com.github.game.menu;

public class MenuFactory {
	public Menu getMenu(Context location) {
		if (location == null) {
			return null;
		}
		switch (location) {
		case TOWER:
			return new Tower();

		default:
			break;

		}
		return null;

	}
}
