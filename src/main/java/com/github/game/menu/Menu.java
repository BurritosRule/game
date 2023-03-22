package com.github.game.menu;

import java.util.List;

import com.github.game.world.Action;

public interface Menu {

	// enum instead?
	public String header();

	public List<Action> possibleInput();

}
