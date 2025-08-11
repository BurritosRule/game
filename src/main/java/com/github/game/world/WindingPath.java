package com.github.game.world;

import java.util.ArrayList;
import java.util.List;

public class WindingPath implements Path, com.github.game.state.GameSerializable<WindingPathDTO> {

  private final Chest chest;

  public WindingPath() {
    this.chest = new Chest();
    // Register this WindingPath in GameState for autosave lookup and persistence
    com.github.game.state.GameState.getInstance().setState(getPersistenceId(), this);
  }

  @Override
  public List<Action> getActions() {
    List<Action> actions = new ArrayList<Action>();

    actions.addAll(chest.getActions());

    return actions;
  }

  @Override
  public String getName() {
    return "Winding Path";
  }

  @Override
  public String getSubLocation() {
    return "sub location";
  }

  @Override
  public String getDescription() {
    return "The winding path snaked through the shadowy forest, illuminated only by the occasional\n"
        + "flicker of ghostly will-o'-wisps. Ancient, gnarled trees arched overhead, their twisted\n"
        + "branches clawing at the murky sky. The air was thick with the scent of damp earth and\n"
        + "decaying leaves, while the distant howl of a creature echoed through the labyrinthine\n"
        + "woods. Along the path, eerie fungi glowed with an unnatural light, casting long, sinister\n"
        + "shadows that seemed to whisper secrets of the forgotten and the damned. This was a\n"
        + "place where light dared not linger, and every step forward felt like a descent into deeper\n"
        + "darkness\n";
  }

  public Chest getChest() {
    return chest;
  }

  // --- Persistence logic for nested chest ---
  @Override
  public String getPersistenceId() {
    return "WindingPath";
  }

  @Override
  public WindingPathDTO toDTO() {
    WindingPathDTO dto = new WindingPathDTO();
    dto.chest = new ChestPersistenceAdapter(chest).toDTO();
    return dto;
  }

  @Override
  public void fromDTO(WindingPathDTO dto) {
    if (dto != null && dto.chest != null) {
      new ChestPersistenceAdapter(chest).fromDTO(dto.chest);
    }
  }

  @Override
  public Class<WindingPathDTO> getDTOClass() {
    return WindingPathDTO.class;
  }
}
