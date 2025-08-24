package com.github.game.world;

import java.util.ArrayList;
import java.util.List;

public class Chest implements Interactable {
  private ChestState chestState;

  public Chest() {
    this.chestState = new ChestState(); // Default internal state
  }

  public Chest(String initialState) {
    this.chestState = new ChestState(initialState);
  }

  @Override
  public List<Action> getActions() {
    List<Action> actions = new ArrayList<Action>();

    if ("opened".equals(chestState.getState())) {
      actions.add(new Action() {
        @Override
        public String getKeyword() {
          return "close chest";
        }

        @Override
        public void execute() {
          if (!"closed".equals(chestState.getState())) {
            chestState.setState("closed");
            EventBusSingleton.getInstance().post(new ChestStateChangedEvent(chestState.getState()));
          }
        }
      });
    } else {
      actions.add(new Action() {
        @Override
        public String getKeyword() {
          return "open chest";
        }

        @Override
        public void execute() {
          if (!"opened".equals(chestState.getState())) {
            chestState.setState("opened");
            EventBusSingleton.getInstance().post(new ChestStateChangedEvent(chestState.getState()));
          }
        }
      });
    }
    return actions;
  }

  // Optionally, add a getter for ChestState if needed for persistence
  public ChestState getChestState() {
    return chestState;
  }

  public void setChestState(ChestState chestState) {
    this.chestState = chestState;
  }
}