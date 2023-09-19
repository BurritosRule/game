package com.github.game.menu;

import java.util.ArrayList;
import java.util.List;

import com.github.game.world.Action;

public class PlayerActions {
	public List<Action> getActions() {

		List<Action> actions = new ArrayList<Action>();

		actions.add(new Action() {

			@Override
			public String getKeyword() {
				return "inventory";
			}

			@Override
			public void execute() {
				System.exit(0);

			}

		});

		actions.add(new Action() {

			@Override
			public String getKeyword() {
				return "stats";
			}

			@Override
			public void execute() {
				System.exit(0);

			}

		});

		return actions;

	}
}
