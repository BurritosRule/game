package com.github.game.state;

public interface GameSerializable<T> {
  String getPersistenceId(); // unique key for registry

  T toDTO();

  void fromDTO(T dto);

  Class<T> getDTOClass();
}
