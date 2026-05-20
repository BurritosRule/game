package com.github.game.world;

public class ChestStateChangedEvent implements DomainEvent {
  private final String newState;

  public ChestStateChangedEvent(String newState) {
    this.newState = newState;
  }

  public String getNewState() {
    return newState;
  }
}
