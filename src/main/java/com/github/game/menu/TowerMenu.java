package com.github.game.menu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.github.game.world.Action;
import com.github.game.world.Tower;

public class TowerMenu implements Menu {

	private final Tower tower;
	private final Collection<Action> additionalActions;
	private final String header;

	public TowerMenu(Tower tower, Collection<Action> additionalActions) {
		this.tower = tower;
		this.additionalActions = new ArrayList<>(additionalActions);
		this.header = "Tower Menu\n----------------------";
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
