package com.github.game.world;

import java.util.ArrayList;
import java.util.List;

import com.github.game.state.Persistable;

public class ChestState implements Persistable {
  private ChestStateType state;
  private final List<Object> domainEvents = new ArrayList<>();

  public ChestState() {
    this(ChestStateType.CLOSED);
  }

  public ChestState(ChestStateType state) {
    this.state = state;
  }

  public ChestStateType getState() {
    return state;
  }

  public void setState(ChestStateType state) {
    if (state != this.state) {
      this.state = state;
      domainEvents.add(new ChestStateChangedEvent(state.name()));
    }
  }

  public List<Object> pullDomainEvents() {
    List<Object> events = new ArrayList<>(domainEvents);
    domainEvents.clear();
    return events;
  }

}
