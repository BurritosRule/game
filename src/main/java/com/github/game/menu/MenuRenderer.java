package com.github.game.menu;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.impl.DefaultParser;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import com.github.game.world.Action;
import com.github.game.world.Location;
import com.github.game.world.Tower;

public class MenuRenderer {

	private final Terminal terminal;
	private final DefaultParser parser;
	private final LineReader reader;

	public MenuRenderer() throws IOException {
		this.terminal = TerminalBuilder.builder().build();
		this.parser = new DefaultParser();
		this.reader = LineReaderBuilder.builder().terminal(terminal).parser(parser).build();

	}

//	public Map<String, Action> renderMenu(Menu menu) {
//		List<Action> possibleInput = null;
//		possibleInput = menu.possibleInput();
//
//		StringBuilder keywords = new StringBuilder();
//
//		Map<String, Action> actions = new HashMap<>();
//		for (Action action : possibleInput) {
//			keywords.append(action.getKeyword()).append("\n");
//			actions.put(action.getKeyword(), action);
//		}
//		return actions;
//
//	}

	// Menu might be of any type, location or otherwise. How best to handle this?
	public Action renderLocationMenu(Menu menu, Location location) {

		String menuSelection = null;
		List<Action> possibleInput = null;

		possibleInput = menu.possibleInput();

		StringBuilder keywords = new StringBuilder();

		Map<String, Action> actions = new HashMap<>();
		for (Action action : possibleInput) {
			keywords.append(action.getKeyword()).append("\n");
			actions.put(action.getKeyword(), action);
		}

		if (location instanceof Tower) {
			terminal.writer().println(menu.header());
			terminal.writer().println("Your current location is floor " + ((Tower) location).getCurrentFloor() + " of "
					+ ((Tower) location).getName() + "\n");
			terminal.writer().println("\n" + keywords);

			menuSelection = reader.readLine("Action > ");
			// actions.get(menuSelection).execute();

			return actions.get(menuSelection);
		}

		throw new IllegalArgumentException("Unrecognized location type: " + location);

	}

}
