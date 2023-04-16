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
import com.github.game.menu.MenuRenderer;
import com.github.game.player.Player;
import com.github.game.player.PlayerImpl;
import com.github.game.world.Action;
import com.github.game.world.TowerImpl;

public class Run {

	public static void main(String[] args) throws IOException {

		TowerImpl castleTower = new TowerImpl("Castle Tower", 10);
		Player player = new PlayerImpl("Hero", castleTower);

//		Terminal terminal = TerminalBuilder.builder().build();
//
//		DefaultParser parser = new DefaultParser();
//		LineReader reader = LineReaderBuilder.builder().terminal(terminal).parser(parser).build();
		
		String menuSelection = null;
		Menu currentMenu = null;

		MenuFactory menuFactory = new MenuFactory();
		Menu menu = menuFactory.getMenu(castleTower);
		Menu playerMenu = menuFactory.createPlayerMenu();

		MenuController menuController = new MenuController();
		MenuRenderer menuRenderer = new MenuRenderer();
		
		menuController.addMenu(playerMenu);
		menuController.addMenu(menu);
		
		currentMenu = menuController.peekLastMenu();
		
		castleTower.getActions().execute();
		
		action = menuRenderer.renderLocationMenu(currentMenu, castleTower);
		actions.execute(menuRenderer.renderLocationMenu(currentMenu, castleTower));
		
		//System.out.println(menuRenderer.renderCurrentMenu(menuController));
//		terminal.writer().println(currentMenu.header());
//		terminal.writer().println("Your current location is floor " + castleTower.getCurrentFloor() + " of "
//				+ castleTower.getName() + "\n");
//		terminal.writer().println("\n" + menuRenderer.renderMenu(currentMenu).keySet());
//
//		menuSelection = reader.readLine("Action > ");
//		menuRenderer.renderMenu(currentMenu).get(menuSelection).execute();

//        while (true) {
//            try {
//                
//    			String menuSelection = null;
//    			List<Action> possibleInput = null;
//    
//    			MenuFactory menuFactory = new MenuFactory();
//    			
//    			Menu menu = menuFactory.getMenu(player.getCurrentLocation());
//    			
//    			possibleInput = menu.possibleInput();
//
//				StringBuilder keywords = new StringBuilder();
//
//				Map<String, Action> actions = new HashMap<>();
//				for (Action action : possibleInput) {
//					keywords.append(action.getKeyword()).append("\n");
//					actions.put(action.getKeyword(), action);
//				}
//
//				terminal.writer().println(menu.header());
//				terminal.writer().println("Your current location is floor " + castleTower.getCurrentFloor() + " of "
//						+ castleTower.getName() + "\n");
//				terminal.writer().println("\n" + keywords);
//
//				menuSelection = reader.readLine("Action > ");
//				actions.get(menuSelection).execute();
//                
//
//            } catch (UserInterruptException e) {
//                // Ignore
//            } catch (EndOfFileException e) {
//                return;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

	}
}