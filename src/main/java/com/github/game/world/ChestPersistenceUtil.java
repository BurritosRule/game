package com.github.game.world;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class ChestPersistenceUtil {
  private static final ObjectMapper objectMapper = new ObjectMapper();

  public static String serializeChest(Chest chest, String chestId) throws IOException {
    ChestStateDTO dto = new ChestStateDTO();
    dto.chestId = chestId;
    dto.opened = "opened".equals(chest.getState());
    return objectMapper.writeValueAsString(dto);
  }

  public static void applyChestState(Chest chest, String json) throws IOException {
    ChestStateDTO dto = objectMapper.readValue(json, ChestStateDTO.class);
    chest.setState(dto.opened ? "opened" : "closed");
  }
}
