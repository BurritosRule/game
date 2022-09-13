package com.github.game.items;

public interface BaseItem {

	// Do I have these individual methods or just throw all item attributes into a
	// hashmap?
	public Boolean isUsable();

	public Boolean isEquipable();

	public Enum<Rarity> rarity();
}