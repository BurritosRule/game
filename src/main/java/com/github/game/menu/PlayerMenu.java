package com.github.game.menu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.github.game.world.Action;
import com.github.game.world.PlayerActions;

public class PlayerMenu implements Menu {

	public String header;
	private final Collection<Action> playerActions;

	public PlayerMenu(Collection<Action> playerActions) {
		this.header = "Player Menu\n----------------------";
		this.playerActions = new ArrayList<>(playerActions);
	}

	@Override
	public String header() {
		return header;
	}

	@Override
	public List<Action> possibleInput() {
		List<Action> possibleInput = (List<Action>) playerActions;
		return possibleInput;
	}

}
