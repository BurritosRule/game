package com.github.game.world;

import java.beans.PropertyChangeListener;
import java.util.List;

public interface Interactable {

  void addPropertyChangeListener(PropertyChangeListener pcl);

  void removePropertyChangeListener(PropertyChangeListener pcl);

  void setState(String state);

  List<Action> getActions();

}
