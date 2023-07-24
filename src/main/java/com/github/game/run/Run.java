package com.github.game.run;

import java.io.IOException;
import java.util.ArrayList;
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
import com.github.game.ui.InfoBannerRenderer;
import com.github.game.ui.LocationRenderer;
import com.github.game.ui.MenuRenderer;
import com.github.game.ui.UiBuilder;
import com.github.game.world.Action;
import com.github.game.world.TowerImpl;

public class Run {

	public static void main(String[] args) throws IOException {

		TowerImpl castleTower = new TowerImpl("Castle Tower", 10);
		Player player = new PlayerImpl("Hero", castleTower);

		Menu currentMenu = null;

		MenuFactory menuFactory = new MenuFactory();
		Menu menu = menuFactory.getMenu(castleTower);
		Menu playerMenu = menuFactory.createPlayerMenu();

		MenuController menuController = new MenuController();
		// menuController.addMenu(playerMenu);
		menuController.addMenu(menu);
		//currentMenu = menuController.peekLastMenu();
		
		
		UiBuilder ui = new UiBuilder();
		Terminal terminal = ui.createTerminal();

		DefaultParser parser = ui.createParser();
		LineReader reader = ui.createReader(terminal, parser);

		InfoBannerRenderer infoBannerRenderer = new InfoBannerRenderer(terminal);
		MenuRenderer menuRenderer = new MenuRenderer(terminal);
		LocationRenderer locationRenderer = new LocationRenderer(terminal);
		ActionExecuter actionExecuter = new ActionExecuter(reader);

		Map<String, Action> actions = new HashMap<>();

		while (true) {
			try {
				infoBannerRenderer.render(player);
				//locationRenderer.render(castleTower);
				actions = menuRenderer.render(menuController.peekLastMenu());
				actionExecuter.executeAction(actions);
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