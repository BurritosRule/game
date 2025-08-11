package com.github.game.player;

import com.github.game.state.GameState;
import com.github.game.world.LocationName;

public class PlayerState implements com.github.game.state.GameSerializable<com.github.game.player.PlayerStateDTO> {
  private LocationName currentLocation;

  public PlayerState(LocationName initialLocation) {
    this.currentLocation = initialLocation;
    GameState.getInstance().setState(getPersistenceId(), this);
  }

  public LocationName getCurrentLocation() {
    return currentLocation;
  }

  public void setCurrentLocation(LocationName location) {
    this.currentLocation = location;
  }

  @Override
  public String getPersistenceId() {
    return "PlayerState";
  }

  @Override
  public com.github.game.player.PlayerStateDTO toDTO() {
    com.github.game.player.PlayerStateDTO dto = new com.github.game.player.PlayerStateDTO();
    dto.playerLocation = currentLocation != null ? currentLocation.name() : null;
    return dto;
  }

  @Override
  public void fromDTO(com.github.game.player.PlayerStateDTO dto) {
    if (dto.playerLocation != null) {
      this.currentLocation = com.github.game.world.LocationName.valueOf(dto.playerLocation);
    }
  }

  @Override
  public Class<com.github.game.player.PlayerStateDTO> getDTOClass() {
    return com.github.game.player.PlayerStateDTO.class;
  }
}
