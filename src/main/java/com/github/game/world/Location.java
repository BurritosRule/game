package com.github.game.world;

import java.util.List;

public interface Location {
  List<Action> getActions();

  public String getName();

  public String getSubLocation();

}
