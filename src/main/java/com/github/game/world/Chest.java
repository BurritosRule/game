package com.github.game.world;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Chest implements Interactable {

  private String state;

  private PropertyChangeSupport support;

  public Chest() {
    support = new PropertyChangeSupport(this);
  }

  public void addPropertyChangeListener(PropertyChangeListener pcl) {
    support.addPropertyChangeListener(pcl);
  }

  public void removePropertyChangeListener(PropertyChangeListener pcl) {
    support.removePropertyChangeListener(pcl);
  }

  public void setState(String value) {
    support.firePropertyChange("state", this.state, value);
    this.state = value;
  }

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
          Chest.this.setState(("closed"));
          ;
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
          Chest.this.setState(("opened"));
          ;
        }
      });
    }
    return actions;
  }
}
