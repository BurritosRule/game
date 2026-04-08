package com.github.game.world;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.service.AutoService;
import com.github.game.state.PersistableDTO;

@AutoService(PersistableDTO.class)
@JsonTypeName("ChestState")
public class ChestStateDTO implements PersistableDTO {
  private ChestStateType state;

  public ChestStateDTO() {
  }

  public ChestStateType getState() {
    return state;
  }

  public void setState(ChestStateType state) {
    this.state = state;
  }
}
