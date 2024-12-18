package com.github.game.ui;

import org.jline.terminal.Terminal;

import com.github.game.player.Player;
import com.github.game.world.Location;

public class LocationDescriptionRenderer {
  private Location location;
  private String description;
  private String separator = "----------------------";

  private Terminal terminal;

  public LocationDescriptionRenderer(Terminal terminal) {
    this.terminal = terminal;

  }

  public void render(Location location) {

    description = location.getDescription();

    terminal.writer().println(description);

  }

}
