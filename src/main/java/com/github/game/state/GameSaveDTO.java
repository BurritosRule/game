package com.github.game.state;

import java.util.ArrayList;
import java.util.List;

public class GameSaveDTO {
  public String schema = "GameSaveV3";
  public List<GameSaveEntry> entries = new ArrayList<>();
}
