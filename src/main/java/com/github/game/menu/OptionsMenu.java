package com.github.game.menu;

import java.util.Collection;
import java.util.List;

import com.github.game.world.Action;

public class OptionsMenu implements Menu {

	public String header;
	private OptionActions optionActions;
	private Collection<Action> additionalActions;

	public OptionsMenu() {
		this.header = "options";
	}

	@Override
	public void addActions(Collection<Action> additionalActions) {
		this.additionalActions = additionalActions;
	}

	@Override
	public String header() {
		return header;
	}

	@Override
	public List<Action> possibleInput() {
		List<Action> possibleInput = optionActions.getActions();
		possibleInput.addAll(additionalActions);
		return possibleInput;
	}

}
