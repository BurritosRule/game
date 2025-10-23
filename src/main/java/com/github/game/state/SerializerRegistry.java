package com.github.game.state;

import java.util.HashMap;
import java.util.Map;

/**
 * Registry for mapping Persistable classes to their serializers.
 */
public class SerializerRegistry {
  private static final Map<Class<? extends Persistable>, Serializer<? extends Persistable>> registry = new HashMap<>();
  private static final Map<String, Class<? extends Persistable>> typeNameToClass = new HashMap<>();

  public static <T extends Persistable> void register(Serializer<T> serializer) {
    registry.put(serializer.type(), serializer);
    typeNameToClass.put(serializer.type().getName(), serializer.type());
  }

  @SuppressWarnings("unchecked")
  public static <T extends Persistable> Serializer<T> getByType(Class<T> clazz) {
    return (Serializer<T>) registry.get(clazz);
  }

  @SuppressWarnings("unchecked")
  public static <T extends Persistable> Serializer<T> getByTypeName(String typeName) {
    Class<T> clazz = (Class<T>) typeNameToClass.get(typeName);
    if (clazz == null)
      return null;
    return (Serializer<T>) registry.get(clazz);
  }
}
