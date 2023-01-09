package com.github.game.menu;

import java.util.List;

import com.github.game.world.Action;
import com.github.game.world.OptionActions;

public class OptionsMenu implements Menu {

	public String header;
	private final OptionActions optionActions;

	public OptionsMenu(OptionActions optionActions) {
		this.header = "options";
		this.optionActions = optionActions;
	}

	@Override
	public String header() {
		return header;
	}

	@Override
	public List<Action> possibleInput() {
		List<Action> possibleInput = optionActions.getActions();
		return possibleInput;
	}

}
