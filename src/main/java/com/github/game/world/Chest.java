package com.github.game.world;

import java.util.ArrayList;
import java.util.List;

import com.github.game.state.ChestFilePersistence;

public class Chest
    implements Interactable, com.github.game.state.GameSerializable<com.github.game.world.ChestStateDTO> {

  private String state;

  public Chest() {
    this.state = "closed"; // Default internal state
    // Only register Chest if it's not part of another Persistable (e.g.,
    // WindingPath)
    // Remove self-registration to avoid standalone persistence
  }

  public Chest(String initialState) {
    this.state = initialState;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
    // [DEBUG] Chest.setState called, new state: " + state
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

  // Chest state is now persisted via ChestFilePersistence in WindingPath and
  // AutoSaveListener

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