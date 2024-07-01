package com.github.game.interactables;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

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

}
