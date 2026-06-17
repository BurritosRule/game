package com.github.game.state;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GameStatePersistence {
  private static final PersistenceService persistenceService = new JacksonPersistenceService();

  public static void saveToFile(GameState gameState, String filepath) {
    try {
      Map<String, PersistableDTO> dtoObjects = new HashMap<>();
      gameState.getAllStateObjects().forEach((key, value) -> dtoObjects.put(key, value.toDTO()));
      persistenceService.save(dtoObjects, filepath);
    } catch (IOException e) {
      System.err.println("Error saving game state to '" + filepath + "': " + e.getMessage());
    }
  }

  public static void loadFromFile(GameState gameState, String filepath) {
    try {
      Map<String, PersistableDTO> loadedDTOs = persistenceService.load(filepath);
      Map<String, Persistable> currentStates = gameState.getAllStateObjects();
      currentStates.clear();
      loadedDTOs.forEach((key, dto) -> currentStates.put(key, dto.toDomain()));
    } catch (IOException e) {
      System.err.println("Error loading game state from '" + filepath + "': " + e.getMessage());
    }
  }
}
