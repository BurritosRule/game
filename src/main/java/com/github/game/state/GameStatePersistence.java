package com.github.game.state;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

public class GameStatePersistence {
  private static final PersistenceService persistenceService = new JacksonPersistenceService();
  private static final Map<Class<? extends Persistable>, PersistableMapper> MAPPERS_BY_DOMAIN;
  private static final Map<Class<? extends PersistableDTO>, PersistableMapper> MAPPERS_BY_DTO;

  static {
    MAPPERS_BY_DOMAIN = new HashMap<>();
    MAPPERS_BY_DTO = new HashMap<>();
    ServiceLoader.load(PersistableMapper.class).forEach(m -> {
      MAPPERS_BY_DOMAIN.put(m.domainType(), m);
      MAPPERS_BY_DTO.put(m.dtoType(), m);
    });
  }

  public static void saveToFile(GameState gameState, String filepath) {
    try {
      Map<String, PersistableDTO> dtoObjects = new HashMap<>();
      gameState.getAllStateObjects().forEach((key, value) -> {
        PersistableMapper mapper = MAPPERS_BY_DOMAIN.get(value.getClass());
        dtoObjects.put(key, mapper.toDTO(value));
      });
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
      loadedDTOs.forEach((key, dto) -> {
        PersistableMapper mapper = MAPPERS_BY_DTO.get(dto.getClass());
        currentStates.put(key, mapper.toDomain(dto));
      });
    } catch (IOException e) {
      System.err.println("Error loading game state from '" + filepath + "': " + e.getMessage());
    }
  }
}
