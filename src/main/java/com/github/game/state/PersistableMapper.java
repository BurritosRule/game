package com.github.game.state;

public interface PersistableMapper {
  Class<? extends Persistable> domainType();

  Class<? extends PersistableDTO> dtoType();

  PersistableDTO toDTO(Persistable domain);

  Persistable toDomain(PersistableDTO dto);
}
