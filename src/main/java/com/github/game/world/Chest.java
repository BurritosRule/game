package com.github.game.world;

import java.util.ArrayList;
import java.util.List;

public class Chest
    implements Interactable, com.github.game.state.GameSerializable<com.github.game.world.ChestStateDTO> {

  private String state;

  public Chest() {
    this.state = "closed";
  }

  public Chest(String initialState) {
    this.state = initialState;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  @Override
  public List<Action> getActions() {
    List<Action> actions = new ArrayList<Action>();

    if ("opened".equals(state)) {
      actions.add(new Action() {
        @Override
        public String getKeyword() {
          return "close chest";
        }

        @Override
        public void execute() {
          if (!"closed".equals(state)) {
            state = "closed";
            EventBusSingleton.getInstance().post(new ChestStateChangedEvent(state));
          }
        }
      });
    } else {
      actions.add(new Action() {
        @Override
        public String getKeyword() {
          return "open chest";
        }

        @Override
        public void execute() {
          if (!"opened".equals(state)) {
            state = "opened";
            EventBusSingleton.getInstance().post(new ChestStateChangedEvent(state));
          }
        }
      });
    }
    return actions;
  }

  @Override
  public String getPersistenceId() {
    return "Chest";
  }

  @Override
  public com.github.game.world.ChestStateDTO toDTO() {
    com.github.game.world.ChestStateDTO dto = new com.github.game.world.ChestStateDTO();
    dto.chestId = "Chest";
    dto.opened = "opened".equals(this.state);
    return dto;
  }

  @Override
  public void fromDTO(com.github.game.world.ChestStateDTO dto) {
    this.state = dto.opened ? "opened" : "closed";
  }

  @Override
  public Class<com.github.game.world.ChestStateDTO> getDTOClass() {
    return com.github.game.world.ChestStateDTO.class;
  }
}