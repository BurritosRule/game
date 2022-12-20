package com.github.game.menu;

import java.util.List;

import com.github.game.world.Action;
import com.github.game.world.GameActions;
import com.github.game.world.Tower;

public class TowerMenu implements Menu {

	private final Tower tower;
	private final GameActions gameActions;

	public TowerMenu(Tower tower) {
		this.tower = tower;
		this.gameActions = new GameActions();
	}

	@Override
	public List<Action> possibleInput() {
		List<Action> possibleInput = tower.getActions();
		possibleInput.addAll(gameActions.getActions());

		return possibleInput;
	}

}
