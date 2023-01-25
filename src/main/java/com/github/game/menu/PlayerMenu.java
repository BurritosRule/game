package com.github.game.menu;

import java.util.List;

import com.github.game.world.Action;
import com.github.game.world.OptionActions;
import com.github.game.world.PlayerActions;

public class PlayerMenu implements Menu {

	public String header;
	private final PlayerActions playerActions;

	public PlayerMenu(PlayerActions playerActions) {
		this.header = "Player Menu\n----------------------";
		this.playerActions = playerActions;
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
