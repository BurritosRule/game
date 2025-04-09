package com.github.game.world;

import java.util.ArrayList;
import java.util.List;

import com.github.game.state.GameState;

public class Chest implements Interactable {

  private String state;

  public Chest() {
    this.state = GameState.getInstance().getChestState();
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
          EventBusSingleton.getInstance().post(new ChestStateChangedEvent("closed"));
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
          EventBusSingleton.getInstance().post(new ChestStateChangedEvent("opened"));
        }
      });
    }
    return actions;
  }
}
