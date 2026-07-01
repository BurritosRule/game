package com.github.game.world;

import java.util.ArrayList;
import java.util.List;

import com.github.game.state.DomainEventPublisher;

public class Chest implements Interactable {
  private final ChestState chestState;
  private final DomainEventPublisher publisher;

  public Chest(ChestState chestState, DomainEventPublisher publisher) {
    this.chestState = chestState;
    this.publisher = publisher;
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
          chestState.setState(ChestStateType.CLOSED);
          chestState.pullDomainEvents().forEach(publisher::publish);
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
          chestState.setState(ChestStateType.OPENED);
          chestState.pullDomainEvents().forEach(publisher::publish);
        }
      });
    }
    return actions;
  }
}