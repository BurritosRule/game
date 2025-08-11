package com.github.game.world;

// DTO for Chest persistence (v1 schema)
public class ChestStateDTO {
  public String schema = "ChestV1";
  public String chestId; // For future: unique identifier if you have multiple chests
  public boolean opened;
}
