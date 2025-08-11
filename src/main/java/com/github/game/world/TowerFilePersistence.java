package com.github.game.world;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TowerFilePersistence {
  private static final String SAVE_PATH = "towerstate.json";

  public static void saveTowerToFile(TowerImpl tower) {
    String json;
    try {
      json = TowerPersistenceUtil.serializeTower(tower);
    } catch (IOException e) {
      throw new RuntimeException("Failed to serialize tower state", e);
    }
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(SAVE_PATH))) {
      writer.write(json);
    } catch (IOException e) {
      throw new RuntimeException("Failed to write tower state to file", e);
    }
  }

  public static void loadTowerFromFile(TowerImpl tower) {
    Path path = Paths.get(SAVE_PATH);
    if (!Files.exists(path)) {
      // File does not exist, skip loading and use default state
      return;
    }
    try {
      String json = new String(Files.readAllBytes(path));
      TowerPersistenceUtil.applyTowerState(tower, json);
    } catch (IOException e) {
      throw new RuntimeException("Failed to read tower state from file", e);
    }
  }
}
