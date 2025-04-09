package com.github.game.ui;

import org.jline.terminal.Terminal;

import com.github.game.player.Player;
import com.github.game.state.GameState;
import com.github.game.world.Location;
import com.github.game.world.LocationName;

public class InfoBannerRenderer {
  private LocationName location;
  private int hp;
  private String weapon;
  private String armor;
  private int gold;
  private String separator = "----------------------";

  private Terminal terminal;

  public InfoBannerRenderer(Terminal terminal) {
    this.terminal = terminal;

  }

  public void render(Player player) {

    // location = player.getCurrentLocation();
    location = GameState.getInstance().getPlayerLocation();
    hp = player.getHp();
    weapon = player.getWeapon();
    armor = player.getArmor();
    gold = player.getGold();

    terminal.writer().println(separator);

    // if (location.getSubLocation() != null) {
    // terminal.writer().println("Location: " + location.getName() + " (" +
    // location.getSubLocation() + ")");

    // } else {
    // terminal.writer().println("Location: " + location.getName());
    // }

    terminal.writer().println("Location: " + location.getDisplayName());

    terminal.writer().println("HP: " + hp);
    terminal.writer().println("Weapon: " + weapon);
    terminal.writer().println("Armor: " + armor);
    terminal.writer().println("Gold: " + gold);
    terminal.writer().println(separator + "\n");

  }

}
