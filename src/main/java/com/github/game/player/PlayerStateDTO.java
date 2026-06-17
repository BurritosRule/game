package com.github.game.player;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.service.AutoService;
import com.github.game.state.PersistableDTO;
import com.github.game.world.LocationName;

@AutoService(PersistableDTO.class)
@JsonTypeName("PlayerState")
public class PlayerStateDTO implements PersistableDTO {
  private String name;
  private LocationName locationName;
  private int hp;
  private String weapon;
  private String armor;
  private int gold;
  private int attack;
  private int defense;

  public PlayerStateDTO() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocationName getLocationName() {
    return locationName;
  }

  public void setLocationName(LocationName locationName) {
    this.locationName = locationName;
  }

  public int getHp() {
    return hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }

  public String getWeapon() {
    return weapon;
  }

  public void setWeapon(String weapon) {
    this.weapon = weapon;
  }

  public String getArmor() {
    return armor;
  }

  public void setArmor(String armor) {
    this.armor = armor;
  }

  public int getGold() {
    return gold;
  }

  public void setGold(int gold) {
    this.gold = gold;
  }

  public int getAttack() {
    return attack;
  }

  public void setAttack(int attack) {
    this.attack = attack;
  }

  public int getDefense() {
    return defense;
  }

  public void setDefense(int defense) {
    this.defense = defense;
  }
}
