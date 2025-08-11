package com.github.game.ui;

import org.jline.terminal.Terminal;

import com.github.game.player.Player;

public class InfoBannerRenderer {
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
    // Use player's current location for display
    String locationDisplay = "Unknown";
    if (player.getCurrentLocation() != null) {
      locationDisplay = player.getCurrentLocation().getName();
    }
    hp = player.getHp();
    weapon = player.getWeapon();
    armor = player.getArmor();
    gold = player.getGold();

    terminal.writer().println(separator);
    terminal.writer().println("Location: " + locationDisplay);
    terminal.writer().println("HP: " + hp);
    terminal.writer().println("Weapon: " + weapon);
    terminal.writer().println("Armor: " + armor);
    terminal.writer().println("Gold: " + gold);
    terminal.writer().println(separator + "\n");
  }

}
