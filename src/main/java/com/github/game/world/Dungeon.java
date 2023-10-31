package com.github.game.world;

public interface Dungeon extends Location {

  public boolean canMoveNorth();

  public boolean canMoveSouth();

  public boolean canMoveWest();

  public boolean canMoveEast();

}
