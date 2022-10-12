package com.github.game.run;

import java.io.IOException;
import java.util.Scanner;

import com.github.game.menu.Menu;
import com.github.game.menu.Context;
import com.github.game.menu.MenuFactory;
import com.github.game.world.TowerImpl;

public class Run {

	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);

		TowerImpl spookyTower = new TowerImpl("Spooky Tower", 10);

		String menuSelection = null;

		MenuFactory menuFactory = new MenuFactory();

		Menu menu = menuFactory.getMenu(Context.TOWER);

//		while (true) {
		while (menuSelection != "exit") {
			
			//while true keep calling menu.possibleInput
			System.out.println(
					"Your current location is floor " + spookyTower.getCurrentFloor() + " of " + spookyTower.getName());

			System.out.print("Ascend or descend? ");

			menuSelection = input.next();
			switch (menuSelection) {
			case "ascend" -> spookyTower.ascend();
			case "descend" -> spookyTower.descend();
			case "exit" -> System.exit(0);
			}
		}

		input.close();
	}
}