package com.github.game.state;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

public class JacksonPersistenceService implements PersistenceService {
  private final ObjectMapper objectMapper;

  public JacksonPersistenceService() {
    this.objectMapper = new ObjectMapper();
    ServiceLoader.load(Persistable.class)
        .stream()
        .map(ServiceLoader.Provider::type)
        .forEach(this.objectMapper::registerSubtypes);
  }

  @Override
  public void save(Map<String, Persistable> stateObjects, String filepath) throws IOException {
    objectMapper.writerFor(new TypeReference<Map<String, Persistable>>() {
    })
        .withDefaultPrettyPrinter()
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
