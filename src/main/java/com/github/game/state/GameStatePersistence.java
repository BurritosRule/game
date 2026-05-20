package com.github.game.state;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GameStatePersistence {
  private final PersistenceService persistenceService;
  private final PersistableMappingRegistry mappingRegistry;

  public GameStatePersistence(PersistenceService persistenceService, PersistableMappingRegistry mappingRegistry) {
    this.persistenceService = persistenceService;
    this.mappingRegistry = mappingRegistry;
  }

  public void save(GameState gameState, String filepath) {
    try {
      Map<String, PersistableDTO> dtoObjects = new HashMap<>();
      gameState.getAllStateObjects().forEach((key, value) -> dtoObjects.put(key, mappingRegistry.toDTO(value)));
      persistenceService.save(dtoObjects, filepath);
    } catch (IOException e) {
      System.err.println("Error saving game state to '" + filepath + "': " + e.getMessage());
    }
  }

  public void load(GameState gameState, String filepath) {
    try {
      Map<String, PersistableDTO> loadedDTOs = persistenceService.load(filepath);
      Map<String, Persistable> domainObjects = new HashMap<>();
      loadedDTOs.forEach((key, dto) -> domainObjects.put(key, dto.toDomain()));
      gameState.replaceAll(domainObjects);
    } catch (IOException e) {
      System.err.println("Error loading game state from '" + filepath + "': " + e.getMessage());
    }
  }
}
