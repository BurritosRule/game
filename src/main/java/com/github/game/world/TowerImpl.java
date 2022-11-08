package com.github.game.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.github.burritodetector.menuparser.MenuItem;

public class TowerImpl implements Tower {

	private String name;
	private int numOfFloors;
	private int currentFloor = 1;

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
		return currentFloor < numOfFloors;

	}

	public void descend() {
		if (currentFloor > 1) {
			currentFloor--;
		} else {
			throw new IllegalStateException("Error: Already on first floor");
		}

	}

	public boolean canDescend() {
		return currentFloor > 1;

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

	@Override
	public List<Action> getActions() {
		
		List<Action> actions = new ArrayList<Action>();
		
		if (this.canAscend()) {
			actions.add(action)
		}

	}

}
