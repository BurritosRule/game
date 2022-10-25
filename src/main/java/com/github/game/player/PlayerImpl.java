package com.github.game.player;

import com.github.game.world.TowerImpl;

public class PlayerImpl implements Player {

	private String name;
	private TowerImpl tower;

	public PlayerImpl(String name, TowerImpl tower) {
		this.setName(name);
		this.tower = tower;

	}

	@Override
	public void setCurrentLocation(TowerImpl tower) {
		this.tower = tower;

	}

	@Override
	public TowerImpl getCurrentLocation() {
		return tower;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
