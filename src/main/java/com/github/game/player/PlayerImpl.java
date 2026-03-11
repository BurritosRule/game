package com.github.game.player;

import com.github.game.world.Location;
import com.github.game.world.LocationName;

public class PlayerImpl implements Player {

  private final PlayerState playerState;
  private Location location;

  public PlayerImpl(PlayerState playerState, Location location) {
    this.playerState = playerState;
    this.location = location;
  }

  private LocationName getLocationNameFromLocation(Location location) {
    // Map location name string to LocationName enum
    String name = location.getName().toUpperCase().replace(" ", "_");
    try {
      return LocationName.valueOf(name);
    } catch (IllegalArgumentException e) {
      return LocationName.UMBRUS; // default fallback
    }
  }

  public void setCurrentLocation(Location location) {
    this.location = location;
    playerState.setLocationName(getLocationNameFromLocation(location));
  }

  public Location getCurrentLocation() {
    return location;
  }

  public String getName() {
    return playerState.getName();
  }

  public void setName(String name) {
    playerState.setName(name);
  }

  public int getHp() {
    return playerState.getHp();
  }

  public void setHp(int hp) {
    playerState.setHp(hp);
  }

  public String getWeapon() {
    return playerState.getWeapon();
  }

  public void setWeapon(String weapon) {
    playerState.setWeapon(weapon);
  }

  public String getArmor() {
    return playerState.getArmor();
  }

  public void setArmor(String armor) {
    playerState.setArmor(armor);
  }

  public int getGold() {
    return playerState.getGold();
  }

  public void setGold(int gold) {
    playerState.setGold(gold);
  }

  public int getAttack() {
    return playerState.getAttack();
  }

  public void setAttack(int attack) {
    playerState.setAttack(attack);
  }

  public int getDefense() {
    return playerState.getDefense();
  }

  public void setDefense(int defense) {
    playerState.setDefense(defense);
  }

  public PlayerState getPlayerState() {
    return playerState;
  }

}
