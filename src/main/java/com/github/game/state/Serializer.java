package com.github.game.state;

/**
 * Generic interface for serializing and deserializing Persistable objects.
 */
public interface Serializer<T extends Persistable> {
  String serialize(T obj, int version);

  T deserialize(String data, int version);

  Class<T> type();

  int version();
}
