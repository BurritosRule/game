package com.github.game.world;

public class StateChangedEvent {
  private final String identifier;
  private final Persistable persistable;

  public StateChangedEvent(String identifier, Persistable persistable) {
    this.identifier = identifier;
    this.persistable = persistable;
  }

  public String getIdentifier() {
    return identifier;
  }

  public Persistable getPersistable() {
    return persistable;
  }
}
