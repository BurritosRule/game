package com.github.game.world;

import java.util.ArrayList;
import java.util.List;

public class WindingPath implements Path, Persistable {

  private final Chest chest;

  public WindingPath() {
    this.chest = new Chest();
    // Do not register in GameState here; let LocationFactory handle registration
    // after loading
  }

  // Persistable implementation
  @Override
  public String getIdentifier() {
    return "WindingPath";
  }

  @Override
  public String serialize() {
    // Example: serialize chest state
    return "chestState=" + chest.getState();
  }

  @Override
  public void deserialize(String data) {
    // [DEBUG] WindingPath.deserialize called with data: " + data
    if (data != null && data.startsWith("chestState=")) {
      String state = data.substring("chestState=".length());
      chest.setState(state);
    }
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

}
