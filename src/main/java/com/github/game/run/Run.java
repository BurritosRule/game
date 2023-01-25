package com.github.game.run;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.github.game.menu.Menu;
import com.github.game.menu.MenuFactory;
import com.github.game.player.Player;
import com.github.game.player.PlayerImpl;
import com.github.game.world.Action;
import com.github.game.world.TowerImpl;

public class Run {

	public static void main(String[] args) throws IOException {
		
		TowerImpl castleTower = new TowerImpl("Castle Tower", 10);
		Player player = new PlayerImpl("Hero", castleTower);

		try (Scanner input = new Scanner(System.in)) {

			String menuSelection = null;
			List<Action> possibleInput = null;

			MenuFactory menuFactory = new MenuFactory();
			
			Menu menu = menuFactory.getMenu(player.getCurrentLocation());

			while (true) {

				possibleInput = menu.possibleInput();
				//header = menu.header();
				StringBuilder keywords = new StringBuilder();

				Map<String, Action> actions = new HashMap<>();
				for (Action action : possibleInput) {
					keywords.append(action.getKeyword()).append("\n");
					actions.put(action.getKeyword(), action);
				}

				System.out.println("Your current location is floor " + castleTower.getCurrentFloor() + " of "
						+ castleTower.getName() + "\n");

				System.out.print(menu.header());
				
				System.out.print("\n" + keywords);

				menuSelection = input.next().toLowerCase();

				actions.get(menuSelection).execute();

			}

		}
	}
}