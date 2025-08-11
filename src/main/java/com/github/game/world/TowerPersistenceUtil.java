package com.github.game.world;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class TowerPersistenceUtil {
  private static final ObjectMapper objectMapper = new ObjectMapper();

  public static String serializeTower(TowerImpl tower) throws IOException {
    TowerStateDTO dto = new TowerStateDTO();
    dto.name = tower.getName();
    dto.numOfFloors = tower.getNumOfFloors();
    dto.currentFloor = tower.getCurrentFloor();
    return objectMapper.writeValueAsString(dto);
  }

  public static void applyTowerState(TowerImpl tower, String json) throws IOException {
    TowerStateDTO dto = objectMapper.readValue(json, TowerStateDTO.class);
    tower.setName(dto.name);
    tower.setNumOfFloors(dto.numOfFloors);
    tower.setCurrentFloor(dto.currentFloor);
  }
}
