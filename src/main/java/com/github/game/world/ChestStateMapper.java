package com.github.game.world;

import com.google.auto.service.AutoService;
import com.github.game.state.Persistable;
import com.github.game.state.PersistableDTO;
import com.github.game.state.PersistableMapper;

@AutoService(PersistableMapper.class)
public class ChestStateMapper implements PersistableMapper {

  @Override
  public Class<? extends Persistable> domainType() {
    return ChestState.class;
  }

  @Override
  public Class<? extends PersistableDTO> dtoType() {
    return ChestStateDTO.class;
  }

  @Override
  public PersistableDTO toDTO(Persistable domain) {
    ChestState state = (ChestState) domain;
    ChestStateDTO dto = new ChestStateDTO();
    dto.setState(state.getState());
    return dto;
  }

  @Override
  public Persistable toDomain(PersistableDTO dto) {
    ChestStateDTO chestDto = (ChestStateDTO) dto;
    return new ChestState(chestDto.getState());
  }
}
