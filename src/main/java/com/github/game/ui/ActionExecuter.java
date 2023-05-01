package com.github.game.ui;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.game.menu.Menu;
import com.github.game.world.Action;

public class ActionExecuter {
	private Menu menu;

	public ActionExecuter(Menu menu) {
		this.menu = menu;
	}

	public void executeAction(String keyword) {

		List<Action> possibleInput = null;
		possibleInput = menu.possibleInput();

		Map<String, Action> actions = new HashMap<>();
		for (Action action : possibleInput) {
			actions.put(action.getKeyword(), action);
		}
		actions.get(keyword).execute();

	}
	
	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}
