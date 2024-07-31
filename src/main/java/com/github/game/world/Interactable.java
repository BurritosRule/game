package com.github.game.world;

import java.beans.PropertyChangeListener;

public interface Interactable {

  void addPropertyChangeListener(PropertyChangeListener pcl);

  void removePropertyChangeListener(PropertyChangeListener pcl);

  void setState(String state);

}
