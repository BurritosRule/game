package com.github.game.state;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JacksonPersistenceService implements PersistenceService {
  private final ObjectMapper objectMapper;

  public JacksonPersistenceService() {
    this.objectMapper = new ObjectMapper();

    // Whitelist only game state packages for security
    PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder()
        .allowIfSubType("com.github.game.player")
        .allowIfSubType("com.github.game.world")
        .allowIfSubType("java.util.concurrent.ConcurrentHashMap")
        .build();

    this.objectMapper.activateDefaultTyping(
        ptv,
        ObjectMapper.DefaultTyping.NON_FINAL,
        com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY);
  }

  @Override
  public void save(Map<String, Persistable> stateObjects, String filepath) throws IOException {
    objectMapper.writerWithDefaultPrettyPrinter()
        .writeValue(new File(filepath), stateObjects);
  }

  @Override
  public Map<String, Persistable> load(String filepath) throws IOException {
    File file = new File(filepath);

    if (!file.exists()) {
      return new HashMap<>();
    }

    return objectMapper.readValue(file,
        new TypeReference<Map<String, Persistable>>() {
        });
  }
}
