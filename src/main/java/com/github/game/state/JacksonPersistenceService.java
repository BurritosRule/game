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
    // More on registerSubtypes vs. @JsonSubTypes here:
    // https://www.baeldung.com/java-jackson-polymorphic-deserialization
    ServiceLoader.load(PersistableDTO.class)
        .stream()
        .map(ServiceLoader.Provider::type)
        .forEach(this.objectMapper::registerSubtypes);
  }

  @Override
  public void save(Map<String, PersistableDTO> dtoObjects, String filepath) throws IOException {
    objectMapper.writerFor(new TypeReference<Map<String, PersistableDTO>>() {
    })
        .withDefaultPrettyPrinter()
        .writeValue(new File(filepath), dtoObjects);
  }

  @Override
  public Map<String, PersistableDTO> load(String filepath) throws IOException {
    File file = new File(filepath);

    if (!file.exists()) {
      return new HashMap<>();
    }

    return objectMapper.readValue(file,
        new TypeReference<Map<String, PersistableDTO>>() {
        });
  }
}
