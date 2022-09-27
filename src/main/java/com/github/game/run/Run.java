package com.github.game.run;

import java.io.IOException;
import java.util.Scanner;

import com.github.game.world.CastleTower;

public class Run {

	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);

		CastleTower spookyTower = new CastleTower("Spooky Tower", 10);

		String menuSelection;

		do {
			System.out.println("Your current location is floor " + spookyTower.getCurrentFloor() + " of "
					+ spookyTower.getTowerName());

			System.out.print("Ascend or descend? ");

			menuSelection = input.next();
			switch (menuSelection) {
			case "ascend" -> spookyTower.ascendTower();
			case "descend" -> spookyTower.desendTower();
			}
		} while (!menuSelection.equals("exit"));
		
		input.close();
	}
}