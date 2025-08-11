package com.github.game.state;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GamePersistence {
  private static final String SAVE_PATH = "savegame.json";
  private static final ObjectMapper objectMapper = new ObjectMapper();

  public static void saveGame() {
    GameSaveDTO dto = new GameSaveDTO();
    try {
      for (Object obj : GameState.getInstance().getAllState().values()) {
        if (obj instanceof GameSerializable) {
          GameSerializable<?> serializable = (GameSerializable<?>) obj;
          GameSaveEntry entry = new GameSaveEntry();
          entry.id = serializable.getPersistenceId();
          entry.type = serializable.getDTOClass().getName();
          entry.dto = serializable.toDTO();
          dto.entries.add(entry);
        }
      }
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(SAVE_PATH))) {
        writer.write(objectMapper.writeValueAsString(dto));
      }
    } catch (IOException e) {
      throw new RuntimeException("Failed to write game state to file", e);
    }
  }

  public static void loadGame() {
    if (!Files.exists(Paths.get(SAVE_PATH))) {
      return;
    }
    try {
      String json = new String(Files.readAllBytes(Paths.get(SAVE_PATH)));
      GameSaveDTO dto = objectMapper.readValue(json, GameSaveDTO.class);
      for (GameSaveEntry entry : dto.entries) {
        Object obj = GameState.getInstance().getState(entry.id);
        if (obj instanceof GameSerializable) {
          GameSerializable<?> serializable = (GameSerializable<?>) obj;
          if (serializable.getDTOClass().getName().equals(entry.type)) {
            Object dtoObj = objectMapper.convertValue(entry.dto, serializable.getDTOClass());
            @SuppressWarnings("unchecked")
            GameSerializable<Object> typed = (GameSerializable<Object>) serializable;
            typed.fromDTO(dtoObj);
          }
        }
      }
    } catch (IOException e) {
      throw new RuntimeException("Failed to read game state from file", e);
    }
  }
}
