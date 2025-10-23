package com.github.game.world;

import com.github.game.state.Persistable;

public class ChestState implements Persistable {
  private ChestStateType state;

  public ChestState() {
    this.state = ChestStateType.CLOSED;
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
      EventBusSingleton.getInstance().post(new ChestStateChangedEvent(state.name()));
    }
  }
}
