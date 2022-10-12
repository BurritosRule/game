package com.github.game.world;

public class TowerImpl implements Tower {

	private String name;
	private int numOfFloors;
	private int currentFloor = 1;
	private boolean canAscend;
	private boolean canDescend;

	public TowerImpl(String name, int numOfFloors) {
		this.name = name;
		this.numOfFloors = numOfFloors;

	}

	public void ascend() {
		if (currentFloor < numOfFloors) {
			currentFloor++;
		} else {
			throw new IllegalStateException("Error: Already on last floor");
		}

	}

	public boolean canAscend() {
		if (currentFloor < numOfFloors) {
			canAscend = true;
		} else {
			canAscend = false;
		}
		return canAscend;
	}

	public void descend() {
		if (currentFloor > 1) {
			currentFloor--;
		} else {
			throw new IllegalStateException("Error: Already on first floor");
		}

	}

	public boolean canDescend() {
		if (currentFloor > 1) {
			canDescend = true;
		} else {
			canDescend = false;
		}
		return canDescend;

	}

	@Override
	public String getName() {
		return name;
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
