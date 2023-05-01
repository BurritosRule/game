package com.github.game.run;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReader.Option;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.UserInterruptException;
import org.jline.reader.impl.DefaultParser;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.Log;

import com.github.game.menu.Menu;
import com.github.game.menu.MenuController;
import com.github.game.menu.MenuFactory;
import com.github.game.player.Player;
import com.github.game.player.PlayerImpl;
import com.github.game.ui.ActionExecuter;
import com.github.game.ui.LocationRenderer;
import com.github.game.ui.MenuRenderer;
import com.github.game.ui.UiBuilder;
import com.github.game.world.Action;
import com.github.game.world.TowerImpl;

public class Run {

	public static void main(String[] args) throws IOException {

		TowerImpl castleTower = new TowerImpl("Castle Tower", 10);
		Player player = new PlayerImpl("Hero", castleTower);

		String menuSelection = null;
		Menu currentMenu = null;

		MenuFactory menuFactory = new MenuFactory();
		Menu menu = menuFactory.getMenu(castleTower);
		Menu playerMenu = menuFactory.createPlayerMenu();

		MenuController menuController = new MenuController();
		menuController.addMenu(playerMenu);
		menuController.addMenu(menu);
		currentMenu = menuController.peekLastMenu();

		UiBuilder ui = new UiBuilder();
		Terminal terminal = ui.getTerminal();
		LineReader reader = ui.getReader();
		DefaultParser parser = ui.getParser();

		MenuRenderer menuRenderer = new MenuRenderer(currentMenu, terminal, reader);
		LocationRenderer locationRenderer = new LocationRenderer(terminal);
		ActionExecuter actionExecuter = new ActionExecuter(currentMenu);

		while (true) {
			try {
				locationRenderer.render(castleTower);
				menuRenderer.render();
				menuSelection = reader.readLine("Action > ");
				actionExecuter.executeAction(menuSelection);
				menuRenderer.setMenu(currentMenu);
				actionExecuter.setMenu(currentMenu);
				;
			} catch (UserInterruptException e) {

			} catch (EndOfFileException e) {
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}