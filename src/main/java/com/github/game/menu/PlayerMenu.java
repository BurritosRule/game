package com.github.game.menu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.github.game.world.Action;

public class PlayerMenu implements Menu {

	public String header;
	private final PlayerActions playerActions;

	public PlayerMenu(List<Action> playerActions) {

		this.header = "Player Menu\n----------------------";
		this.playerActions = (PlayerActions) playerActions;
	}

	@Override
	public String header() {
		return header;
	}

	@Override
	public List<Action> possibleInput() {
		List<Action> possibleInput = playerActions.getActions();
		return possibleInput;
	}

}
