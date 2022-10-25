package com.github.game.player;

import com.github.game.world.TowerImpl;

public interface Player {
	void setCurrentLocation(TowerImpl tower);
	TowerImpl getCurrentLocation();
	void setName(String name);
	String getName();
}
