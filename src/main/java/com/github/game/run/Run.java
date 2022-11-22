package com.github.game.run;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.github.game.menu.Menu;
import com.github.game.menu.MenuFactory;
import com.github.game.player.Player;
import com.github.game.player.PlayerImpl;
import com.github.game.world.Action;
import com.github.game.world.TowerImpl;

public class Run {

	public static void main(String[] args) throws IOException {

		try (Scanner input = new Scanner(System.in)) {

			String menuSelection = null;
			List<Action> possibleInput = null;

			TowerImpl spookyTower = new TowerImpl("Spooky Tower", 10);

			MenuFactory menuFactory = new MenuFactory();

			Menu menu = menuFactory.getMenu(spookyTower);

			while (true) {
				
				possibleInput = menu.possibleInput();
				StringBuilder keywords = new StringBuilder();
				
				for (int i = 0; i < possibleInput.size(); i++) {
					keywords.append(possibleInput.get(i).getKeyword()).append("\n");
				}
				
				System.out.println("Your current location is floor " + spookyTower.getCurrentFloor() + " of "
						+ spookyTower.getName());

				System.out.print("\nOptions: \n" + keywords);

				menuSelection = input.next();
				switch (menuSelection) {
				case "ascend" -> spookyTower.ascend();
				case "descend" -> spookyTower.descend();
				case "exit" -> System.exit(0);
				}
			}

		}
	}
}