package com.github.game.world;

import java.util.ArrayList;
import java.util.List;

public class Chest implements Interactable {
  private final ChestState chestState;

  public Chest(ChestState chestState) {
    this.chestState = chestState;
  }

  @Override
  public List<Action> getActions() {
    List<Action> actions = new ArrayList<Action>();

    if (chestState.getState() == ChestStateType.OPENED) {
      actions.add(new Action() {
        @Override
        public String getKeyword() {
          return "close chest";
        }

        @Override
        public void execute() {
          if (chestState.getState() != ChestStateType.CLOSED) {
            chestState.setState(ChestStateType.CLOSED);
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
          if (chestState.getState() != ChestStateType.OPENED) {
            chestState.setState(ChestStateType.OPENED);
          }
        }
      });
    }
    return actions;
  }
}