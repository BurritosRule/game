package com.github.game.state;

import java.io.IOException;
import java.util.Map;

public class GameStatePersistence {
  private static final PersistenceService persistenceService = new JacksonPersistenceService();

  public static void saveToFile(GameState gameState, String filepath) {
    try {
      Map<String, Persistable> stateObjects = gameState.getAllStateObjects();
      persistenceService.save(stateObjects, filepath);
    } catch (IOException e) {
      // Convert to a logger
      System.err.println("Error saving game state to '" + filepath + "': " + e.getMessage());
    }
  }

  public static void loadFromFile(GameState gameState, String filepath) {
    try {
      Map<String, Persistable> loadedStates = persistenceService.load(filepath);

      // Clear existing state and replace with loaded state
      Map<String, Persistable> currentStates = gameState.getAllStateObjects();
      currentStates.clear();
      currentStates.putAll(loadedStates);

    } catch (IOException e) {
      // Convert to a logger
      System.err.println("Error loading game state from '" + filepath + "': " + e.getMessage());
    }
  }
}
