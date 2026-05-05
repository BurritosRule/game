package com.github.game.state;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

public class PersistableMappingRegistry {
  private final Map<Class<? extends Persistable>, Constructor<? extends PersistableDTO>> mappings = new HashMap<>();

  public PersistableMappingRegistry() {
    ServiceLoader.load(PersistableDTO.class)
        .stream()
        .map(ServiceLoader.Provider::type)
        .forEach(this::registerDTO);
  }

  private void registerDTO(Class<?> dtoClass) {
    Constructor<?> mappingConstructor = null;
    for (Constructor<?> constructor : dtoClass.getConstructors()) {
      if (constructor.getAnnotation(MapsFrom.class) != null) {
        if (mappingConstructor != null) {
          throw new IllegalStateException(
              dtoClass.getName() + " has multiple @MapsFrom constructors");
        }
        mappingConstructor = constructor;
      }
    }
    if (mappingConstructor == null) {
      throw new IllegalStateException(
          dtoClass.getName() + " has no @MapsFrom constructor");
    }
    @SuppressWarnings("unchecked")
    Constructor<? extends PersistableDTO> typedConstructor = (Constructor<? extends PersistableDTO>) mappingConstructor;
    mappings.put(mappingConstructor.getAnnotation(MapsFrom.class).value(), typedConstructor);
  }

  public PersistableDTO toDTO(Persistable domain) {
    Constructor<? extends PersistableDTO> constructor = mappings.get(domain.getClass());
    if (constructor == null) {
      throw new IllegalStateException(
          "No DTO mapping found for " + domain.getClass().getName());
    }
    try {
      return constructor.newInstance(domain);
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
      throw new IllegalStateException(
          "Failed to map " + domain.getClass().getName() + " to DTO", e);
    }
  }
}
