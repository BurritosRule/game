package com.github.game.menu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.github.game.world.Action;
import com.github.game.world.Tower;

public class TowerMenu implements Menu {

	private final Tower tower;
	private final Collection<Action> additionalActions;
	private final Collection<Action> playerActions;
	private final String header;

	public TowerMenu(Tower tower, Collection<Action> additionalActions, Collection<Action> playerActions) {
		this.tower = tower;
		this.additionalActions = new ArrayList<>(additionalActions);
		this.playerActions = new ArrayList<>(playerActions);
		this.header = "Tower Menu\n----------------------";
	}

	@Override
	public List<Action> possibleInput() {
		List<Action> possibleInput = tower.getActions();
		possibleInput.addAll(playerActions);
		possibleInput.addAll(additionalActions);

		return possibleInput;
	}

	@Override
	public String header() {
		return header;
	}

}
