package com.github.game.world;

public class CastleTower implements Tower {

	private String towerName;
	private int numOfFloors;
	private int currentFloor = 1;

	public CastleTower(String towerName, int numOfFloors) {
		this.towerName = towerName;
		this.numOfFloors = numOfFloors;

	}

	public void ascendTower() {
		if (currentFloor + 1 < numOfFloors) {
			currentFloor += 1;
		} else {
			throw new IllegalArgumentException("Error: Already on last floor");
		}

	}

	public void desendTower() {
		if (currentFloor - 1 > 0) {
			currentFloor -= 1;
		} else {
			throw new IllegalArgumentException("Error: Already on first floor");
		}

	}

	@Override
	public String getTowerName() {
		return towerName;
	}

	@Override
	public int getNumOfFloors() {
		return numOfFloors;
	}

	@Override
	public int getCurrentFloor() {
		return currentFloor;
	}

}
