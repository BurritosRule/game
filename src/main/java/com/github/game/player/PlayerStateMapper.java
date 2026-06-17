package com.github.game.player;

import com.google.auto.service.AutoService;
import com.github.game.state.Persistable;
import com.github.game.state.PersistableDTO;
import com.github.game.state.PersistableMapper;

@AutoService(PersistableMapper.class)
public class PlayerStateMapper implements PersistableMapper {

  @Override
  public Class<? extends Persistable> domainType() {
    return PlayerState.class;
  }

  @Override
  public Class<? extends PersistableDTO> dtoType() {
    return PlayerStateDTO.class;
  }

  @Override
  public PersistableDTO toDTO(Persistable domain) {
    PlayerState state = (PlayerState) domain;
    PlayerStateDTO dto = new PlayerStateDTO();
    dto.setName(state.getName());
    dto.setLocationName(state.getLocationName());
    dto.setHp(state.getHp());
    dto.setWeapon(state.getWeapon());
    dto.setArmor(state.getArmor());
    dto.setGold(state.getGold());
    dto.setAttack(state.getAttack());
    dto.setDefense(state.getDefense());
    return dto;
  }

  @Override
  public Persistable toDomain(PersistableDTO dto) {
    PlayerStateDTO playerDto = (PlayerStateDTO) dto;
    return new PlayerState(
        playerDto.getName(),
        playerDto.getLocationName(),
        playerDto.getHp(),
        playerDto.getWeapon(),
        playerDto.getArmor(),
        playerDto.getGold(),
        playerDto.getAttack(),
        playerDto.getDefense());
  }
}
