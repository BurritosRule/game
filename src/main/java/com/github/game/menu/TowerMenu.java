package com.github.game.menu;

import java.util.List;

import com.github.game.world.Action;
import com.github.game.world.Tower;

public class TowerMenu implements Menu {

	private final Tower tower;

	public TowerMenu(Tower tower) {
		this.tower = tower;
	}

	@Override
	public List<Action> possibleInput() {
		return tower.getActions();
	}

}
