package com.github.game.player;

import com.github.game.world.Location;

public interface Player {
	void setCurrentLocation(Location location);

	Location getCurrentLocation();

	void setName(String name);

	String getName();
}
