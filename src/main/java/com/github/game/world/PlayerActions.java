package com.github.game.world;

import java.util.ArrayList;
import java.util.List;

public class PlayerActions {
	public List<Action> getActions() {

		List<Action> actions = new ArrayList<Action>();

		actions.add(new Action() {

			@Override
			public String getKeyword() {
				return "player";
			}

			@Override
			public void execute() {
				System.exit(0);

			}
		});
		return actions;

	}
}
