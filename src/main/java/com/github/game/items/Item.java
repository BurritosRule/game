package com.github.game.items;

public interface Item {

	public Boolean isUsable();

	public Boolean isEquipable();

	public Enum<Rarity> rarity();
}