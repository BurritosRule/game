package com.github.game.interactables;

import java.beans.PropertyChangeListener;

public interface Interactable {

  void addPropertyChangeListener(PropertyChangeListener pcl);

  void removePropertyChangeListener(PropertyChangeListener pcl);

  void setState(String state);

}
