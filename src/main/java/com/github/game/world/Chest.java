package com.github.game.world;

import java.util.ArrayList;
import java.util.List;

public class Chest implements Interactable, Persistable {

  private String state;

  public Chest() {
    this.state = "closed"; // Default internal state
    // Only register Chest if it's not part of another Persistable (e.g.,
    // WindingPath)
    // Remove self-registration to avoid standalone persistence
  }

  public Chest(String initialState) {
    this.state = initialState;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
    // [DEBUG] Chest.setState called, new state: " + state
  }

  @Override
  public String getIdentifier() {
    return "Chest";
  }

  @Override
  public String serialize() {
    return state;
  }

  @Override
  public void deserialize(String data) {
    this.state = data;
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