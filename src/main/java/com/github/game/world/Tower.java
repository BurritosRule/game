package com.github.game.world;

public interface Tower {

	public String getTowerName();

	public int getNumOfFloors();

	public int getCurrentFloor();

	public void ascendTower();

	public void desendTower();

}
