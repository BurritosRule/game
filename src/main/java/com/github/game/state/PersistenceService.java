package com.github.game.state;

import java.io.IOException;
import java.util.Map;

/**
 * Interface for saving and loading game state.
 */
public interface PersistenceService {
  void save(Map<String, PersistableDTO> dtoObjects, String filepath) throws IOException;

  Map<String, PersistableDTO> load(String filepath) throws IOException;
}
