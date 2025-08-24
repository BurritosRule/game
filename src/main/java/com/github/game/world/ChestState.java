package com.github.game.world;

import com.github.game.state.Persistable;

public class ChestState implements Persistable {
  private String state;

  public ChestState() {
    this.state = "closed";
  }

  public ChestState(String state) {
    this.state = state;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    if (!state.equals(this.state)) {
      this.state = state;
      EventBusSingleton.getInstance().post(new ChestStateChangedEvent(state));
    }
  }
}
