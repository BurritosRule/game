package com.github.game.world;

public class ChestStateChangedEvent {
  private final String newState;

  public ChestStateChangedEvent(String newState) {
    this.newState = newState;
  }

  public String getNewState() {
    return newState;
  }
}