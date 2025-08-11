package com.github.game.world;

import com.github.game.state.GameSerializable;

public class ChestPersistenceAdapter implements GameSerializable<ChestStateDTO> {
  private final Chest chest;

  public ChestPersistenceAdapter(Chest chest) {
    this.chest = chest;
  }

  @Override
  public String getPersistenceId() {
    return "Chest";
  }

  @Override
  public ChestStateDTO toDTO() {
    ChestStateDTO dto = new ChestStateDTO();
    dto.chestId = "Chest";
    dto.opened = "opened".equals(chest.getState());
    return dto;
  }

  @Override
  public void fromDTO(ChestStateDTO dto) {
    chest.setState(dto.opened ? "opened" : "closed");
  }

  @Override
  public Class<ChestStateDTO> getDTOClass() {
    return ChestStateDTO.class;
  }
}
