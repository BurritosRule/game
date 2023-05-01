package com.github.game.ui;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.impl.DefaultParser;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import com.github.game.menu.Menu;
import com.github.game.world.Action;
import com.github.game.world.Location;
import com.github.game.world.Tower;

public class MenuRenderer {
	private Menu menu;
	private final Terminal terminal;
	private final LineReader reader;

	public MenuRenderer(Menu menu, Terminal terminal, LineReader reader) {
		this.menu = menu;
		this.terminal = terminal;
		this.reader = reader;

	}

	public void render() {

		List<Action> possibleInput = null;

		possibleInput = menu.possibleInput();

		StringBuilder keywords = new StringBuilder();

		Map<String, Action> actions = new HashMap<>();
		for (Action action : possibleInput) {
			keywords.append(action.getKeyword()).append("\n");
			actions.put(action.getKeyword(), action);
		}

		terminal.writer().println(menu.header());
		terminal.writer().println("\n" + keywords);

	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}
