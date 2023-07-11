package com.github.game.menu;

import java.util.ArrayList;
import java.util.List;

import com.github.game.world.Action;

public class Menus {
	public List<Action> getActions(MenuFactory menuFactory, MenuController menuController) {
		final Menu playerMenu = menuFactory.createPlayerMenu();
		List<Action> menus = new ArrayList<Action>();
		menus.add(new Action() {

			@Override
			public String getKeyword() {
				return "player";
			}

			@Override
			public void execute() {

				menuController.addMenu(playerMenu);

			}
		});
		return menus;
	}

}
