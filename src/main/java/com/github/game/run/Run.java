package com.github.game.run;

import java.io.IOException;

import com.github.game.items.Sword;

public class Run {

	public static void main(String[] args) throws IOException {

		Sword sword = new Sword();

		System.out.println(sword.isUsable());
		System.out.println(sword.isEquipable());
		System.out.println(sword.rarity());

	}
}