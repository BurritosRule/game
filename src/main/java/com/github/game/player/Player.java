package com.github.game.player;

import com.github.game.world.Location;

public interface Player {
  void setCurrentLocation(Location location);

  Location getCurrentLocation();

  void setName(String name);

  void setWeapon(String weapon);

  void setArmor(String armor);

  void setHp(int hp);

  void setGold(int gold);

  String getName();

  String getWeapon();

  String getArmor();

  int getGold();

  int getHp();

  int getAttack();
  
  void setAttack(int attack);

  int getDefense();

  void setDefense(int defense);
}
