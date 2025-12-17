package com.github.game.state;

import java.io.IOException;
import java.util.Map;

/**
 * Handles saving and loading of game state using JSON serialization.
 * Separates persistence logic from state management.
 */
public class GameStatePersistence {
  private static final PersistenceService persistenceService = new JacksonPersistenceService();

  /**
   * Save all state objects from GameState to a file.
   */
  public static void saveToFile(GameState gameState, String filepath) {
    try {
      Map<String, Persistable> stateObjects = gameState.getAllStateObjects();
      persistenceService.save(stateObjects, filepath);
      System.out.println("Game state saved to: " + filepath);
    } catch (IOException e) {
      System.err.println("Error saving game state to '" + filepath + "': " + e.getMessage());
      e.printStackTrace();
    }
  }

  /**
   * Load state objects from a file into GameState.
   */
  public static void loadFromFile(GameState gameState, String filepath) {
    try {
      Map<String, Persistable> loadedStates = persistenceService.load(filepath);

      // Clear existing state and replace with loaded state
      Map<String, Persistable> currentStates = gameState.getAllStateObjects();
      currentStates.clear();
      currentStates.putAll(loadedStates);

      System.out.println("Game state loaded from: " + filepath);
    } catch (IOException e) {
      System.err.println("Error loading game state from '" + filepath + "': " + e.getMessage());
      System.out.println("Starting with default state.");
    }
  }
}
