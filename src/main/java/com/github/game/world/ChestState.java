package com.github.game.world;

import com.github.game.state.Persistable;

/**
 * Represents the internal state of a Chest.
 */
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
    this.state = state;
  }
}
