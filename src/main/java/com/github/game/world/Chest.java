package com.github.game.world;

import java.util.ArrayList;
import java.util.List;

public class Chest implements Interactable {

  private String state;

  public Chest() {
    this.state = "closed"; // Default internal state
  }

  public Chest(String initialState) {
    this.state = initialState;
  }

  @Override
  public List<Action> getActions() {
    List<Action> actions = new ArrayList<Action>();

    if ("opened".equals(state)) {
      actions.add(new Action() {
        @Override
        public String getKeyword() {
          return "close chest";
        }

        @Override
        public void execute() {
          if (!"closed".equals(state)) {
            state = "closed";
            EventBusSingleton.getInstance().post(new ChestStateChangedEvent(state));
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
          if (!"opened".equals(state)) {
            state = "opened";
            EventBusSingleton.getInstance().post(new ChestStateChangedEvent(state));
          }
        }
      });
    }
    return actions;
  }
}