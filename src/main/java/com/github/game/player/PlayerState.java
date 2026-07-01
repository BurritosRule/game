package com.github.game.player;

import java.util.ArrayList;
import java.util.List;

import com.github.game.state.Persistable;
import com.github.game.world.LocationChangedEvent;
import com.github.game.world.LocationName;

public class PlayerState implements Persistable {
  private String name;
  private LocationName locationName;
  private int hp;
  private String weapon;
  private String armor;
  private int gold;
  private int attack;
  private int defense;
  private final List<Object> domainEvents = new ArrayList<>();

  public PlayerState() {
    this.name = "Hero";
    this.locationName = LocationName.UMBRUS;
    this.hp = 100;
    this.weapon = "Sword";
    this.armor = "Chainmail";
    this.gold = 100;
    this.attack = 10;
    this.defense = 10;
  }

  PlayerState(String name, LocationName locationName, int hp, String weapon, String armor, int gold, int attack,
      int defense) {
    this.name = name;
    this.locationName = locationName;
    this.hp = hp;
    this.weapon = weapon;
    this.armor = armor;
    this.gold = gold;
    this.attack = attack;
    this.defense = defense;
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
    if (locationName != this.locationName) {
      this.locationName = locationName;
      domainEvents.add(new LocationChangedEvent(locationName));
    }
  }

  public List<Object> pullDomainEvents() {
    List<Object> events = new ArrayList<>(domainEvents);
    domainEvents.clear();
    return events;
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
