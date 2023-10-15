package com.github.game.menu;

import java.util.Collection;

import com.github.game.world.Action;

public class MenuUpdater {

	private MenuController menuController;

	public MenuUpdater(MenuController menuController) {

		this.menuController = menuController;
	}

	public void updateMenu(Menu menu, Collection<Action> additionalActions) {
		menu.addActions(additionalActions);
		menuController.addMenu(menu);

	}

}
