package com.github.game.menu;

import java.util.Collection;
import java.util.List;

import com.github.game.world.Action;
import com.github.game.world.Tower;

public class TowerMenu implements Menu {

	private final Tower tower;
	private Collection<Action> additionalActions;
	private final String header;

	public TowerMenu(Tower tower) {
		this.tower = tower;
		this.header = "Tower Menu\n----------------------";
	}

	@Override
	public void addActions(Collection<Action> additionalActions) {
		this.additionalActions = additionalActions;

	}

	@Override
	public List<Action> possibleInput() {
		List<Action> possibleInput = tower.getActions();
		possibleInput.addAll(additionalActions);

		return possibleInput;
	}

	@Override
	public String header() {
		return header;
	}

}
