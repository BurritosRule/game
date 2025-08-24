package com.github.game.world;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class UmbrusPersistenceUtil {
  private static final ObjectMapper objectMapper = new ObjectMapper();

  public static String serializeUmbrus(Umbrus umbrus) throws IOException {
    UmbrusStateDTO dto = new UmbrusStateDTO();
    // Populate dto fields from umbrus as needed
    return objectMapper.writeValueAsString(dto);
  }

  public static void applyUmbrusState(Umbrus umbrus, String json) throws IOException {
    UmbrusStateDTO dto = objectMapper.readValue(json, UmbrusStateDTO.class);
    // Apply dto fields to umbrus as needed
  }
}
