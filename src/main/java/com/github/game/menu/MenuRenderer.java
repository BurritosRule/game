package com.github.game.menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.game.world.Action;

public class MenuRenderer {

	public Map<String, Action> renderMenu(Menu menu) {
		List<Action> possibleInput = null;
		possibleInput = menu.possibleInput();

		StringBuilder keywords = new StringBuilder();

		Map<String, Action> actions = new HashMap<>();
		for (Action action : possibleInput) {
			keywords.append(action.getKeyword()).append("\n");
			actions.put(action.getKeyword(), action);
		}
		return actions;

	}
}
