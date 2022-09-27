package com.github.game.items;

public class Sword implements Item {

	@Override
	public Boolean isUsable() {
		return false;

	}

	@Override
	public Boolean isEquipable() {
		return true;

	}

	@Override
	public Enum<Rarity> rarity() {
		return Rarity.COMMON;
	}

}
