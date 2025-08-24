package com.github.game.world;

public interface Persistable {
  String getIdentifier();

  String serialize(); // For saving to file

  void deserialize(String data); // For loading from file
}
