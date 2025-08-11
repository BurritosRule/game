package com.github.game.world;

public class StateChangedEvent {
  private final String identifier;
  private final Object persistable;

  public StateChangedEvent(String identifier, Object persistable) {
    this.identifier = identifier;
    this.persistable = persistable;
  }

  public String getIdentifier() {
    return identifier;
  }

  public Object getPersistable() {
    return persistable;
  }
}
