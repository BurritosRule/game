package com.github.game.run;

import java.io.IOException;
import java.util.Scanner;

import com.github.game.menu.Menu;
import com.github.game.menu.MenuFactory;
import com.github.game.player.Player;
import com.github.game.player.PlayerImpl;
import com.github.game.world.TowerImpl;

public class Run {

	public static void main(String[] args) throws IOException {

		try (Scanner input = new Scanner(System.in)) {

			String menuSelection = null;

			//Menu menu = menuFactory.getMenu(spookyTower);
			
			TowerImpl spookyTower = new TowerImpl("Spooky Tower", 10);
			
			Player player = new PlayerImpl("Hero", spookyTower);
			
			MenuFactory menuFactory = new MenuFactory();
			
			Menu menu = menuFactory.getMenu(spookyTower);
			
			//Menu menu = menuFactory.getMenu(player.getCurrentLocation());

			while (true) {
				// while true keep calling menu.possibleInput
				System.out.println("Your current location is floor " + spookyTower.getCurrentFloor() + " of "
						+ spookyTower.getName());

				System.out.print("Ascend or descend? ");

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