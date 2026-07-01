package com.github.game.world;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.github.game.state.Persistable;

public class ChestState implements Persistable {
  private ChestStateType state;
  private List<ChestStateListener> listeners;

  public ChestState() {
    this(ChestStateType.CLOSED);
  }

  public ChestState(ChestStateType state) {
    this.state = state;
    this.listeners = new CopyOnWriteArrayList<ChestStateListener>();
  }

  public ChestStateType getState() {
    return state;
  }

public void addListener(ChestStateListener listener) {
    listeners.add(listener);
  }

  public void setState(ChestStateType state) {
    if (state != this.state) {
      this.state = state;
      for (ChestStateListener listener : listeners) {
        listener.stateChanged(new ChestStateChangedEvent(state.name()));
      }
      EventBusSingleton.getInstance().post(new ChestStateChangedEvent(state.name()));
    }
  }

}
