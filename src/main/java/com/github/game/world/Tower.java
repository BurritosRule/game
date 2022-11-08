package com.github.game.world;

public interface Tower extends Location {

	public String getName();

	public int getNumOfFloors();

	public int getCurrentFloor();

	public void ascend();
	
	public boolean canAscend();

	public void descend();
	
	public boolean canDescend();

}
