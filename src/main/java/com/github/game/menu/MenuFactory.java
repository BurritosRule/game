package com.github.game.menu;

import com.github.game.world.OptionActions;
import com.github.game.world.PlayerActions;
import com.github.game.world.Location;
import com.github.game.world.Tower;

public class MenuFactory {
	public Menu getMenu(String menuType) {
		
		switch (menuType) {
		case "player":
			return new PlayerMenu(new PlayerActions().getActions());
		case "options":
			// code block
			break;
		default:
			//actions.get(menuSelection).execute();
		}

		throw new IllegalArgumentException("Unrecognized menu type: " + menuType);

	}
}
