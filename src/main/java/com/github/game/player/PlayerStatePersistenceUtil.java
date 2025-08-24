package com.github.game.player;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.game.world.LocationName;
import java.io.IOException;

public class PlayerStatePersistenceUtil {
  private static final ObjectMapper objectMapper = new ObjectMapper();

  public static String serializePlayerState(PlayerState playerState) throws IOException {
    PlayerStateDTO dto = new PlayerStateDTO();
    dto.playerLocation = playerState.getCurrentLocation() != null ? playerState.getCurrentLocation().name() : null;
    return objectMapper.writeValueAsString(dto);
  }

  public static void applyPlayerState(PlayerState playerState, String json) throws IOException {
    PlayerStateDTO dto = objectMapper.readValue(json, PlayerStateDTO.class);
    if (dto.playerLocation != null) {
      playerState.setCurrentLocation(LocationName.valueOf(dto.playerLocation));
    }
  }
}
