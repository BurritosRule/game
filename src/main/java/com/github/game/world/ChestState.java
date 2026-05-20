package com.github.game.world;

import com.github.game.state.Persistable;

public class ChestState implements Persistable {
  private ChestStateType state;
  private DomainEventPublisher publisher = event -> {};

  public ChestState() {
    this.state = ChestStateType.CLOSED;
  }

  public ChestState(ChestStateType state) {
    this.state = state;
  }

  public void setPublisher(DomainEventPublisher publisher) {
    this.publisher = publisher;
  }

  public ChestStateType getState() {
    return state;
  }

  public void setState(ChestStateType state) {
    if (state != this.state) {
      this.state = state;
      publisher.publish(new ChestStateChangedEvent(this.state.name()));
    }
  }

}
