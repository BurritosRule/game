package com.github.game.world;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.service.AutoService;
import com.github.game.state.Persistable;
import com.github.game.state.PersistableDTO;

@AutoService(PersistableDTO.class)
@JsonTypeName("ChestState")
public class ChestStateDTO implements PersistableDTO {
  private ChestStateType state;

  public ChestStateDTO() {
  }

  public ChestStateDTO(ChestState chestState) {
    this.state = chestState.getState();
  }

  @Override
  public Persistable toDomain() {
    return new ChestState(state);
  }

  public ChestStateType getState() {
    return state;
  }

  public void setState(ChestStateType state) {
    this.state = state;
  }
}
