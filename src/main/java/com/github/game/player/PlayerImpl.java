package com.github.game.player;

import com.github.game.world.Location;

public class PlayerImpl implements Player {

	private String name;
	private Location location;
	private int hp;
	// Weapons and armor won't be strings. This is for testing purposes.
	private String weapon;
	private String armor;
	private int gold;

	public PlayerImpl(String name, Location location) {
		this.name = name;
		this.location = location;
		this.hp = 100;
		this.weapon = "Sword";
		this.armor = "Chainmail";
		this.gold = 100;

	}

	public void setCurrentLocation(Location location) {
		this.location = location;

	}

	public Location getCurrentLocation() {
		return location;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	public String getArmor() {
		return armor;
	}

	public void setArmor(String armor) {
		this.armor = armor;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

}
