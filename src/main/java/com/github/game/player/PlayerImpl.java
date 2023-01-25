package com.github.game.player;

import com.github.game.world.Location;

public class PlayerImpl implements Player {

	private String name;
	private Location location;

	public PlayerImpl(String name, Location location) {
		this.setName(name);
		this.location = location;

	}

	@Override
	public void setCurrentLocation(Location location) {
		this.location = location;

	}

	@Override
	public Location getCurrentLocation() {
		return location;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
