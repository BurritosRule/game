package com.github.game.state;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.service.AutoService;
import com.github.game.world.ChestState;
import com.github.game.world.ChestStateType;

@AutoService(PersistableDTO.class)
@JsonTypeName("ChestState")
public class ChestStateDTO implements PersistableDTO {
  private ChestStateType state;

  public ChestStateDTO() {
  }

  @MapsFrom(ChestState.class)
  public ChestStateDTO(ChestState state) {
    this.state = state.getState();
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
