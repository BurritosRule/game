package com.github.game.world;

import java.util.ArrayList;
import java.util.List;

public class Chest implements Interactable {
  private ChestState chestState;

  // Default internal state
  public Chest() {
    this.chestState = new ChestState();
  }

  // Allow Chest to be created with a specific initial state
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
          }
        }
      });
    }
    return actions;
  }
}