package com.github.game.world;

import java.util.ArrayList;
import java.util.List;

import com.github.game.state.GameState;

public class WindingPath implements Path {

  private final Chest chest;

  public WindingPath() {
    chest = new Chest();
    GameState.getInstance().addStateObject("winding_path_chest_1", chest.getChestState());
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

}
