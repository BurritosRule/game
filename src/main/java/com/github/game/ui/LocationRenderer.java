package com.github.game.ui;

import org.jline.terminal.Terminal;

import com.github.game.world.Location;
import com.github.game.world.Tower;

public class LocationRenderer {

	private final Terminal terminal;

	public LocationRenderer(Terminal terminal) {
		this.terminal = terminal;
	}

	public void render(Location location) {
		if (location instanceof Tower) {
			terminal.writer().println("Your current location is floor " + ((Tower) location).getCurrentFloor() + " of "
					+ ((Tower) location).getName() + "\n");
		} else {
			throw new IllegalArgumentException("Unrecognized location type: " + location);
		}
	}

}
