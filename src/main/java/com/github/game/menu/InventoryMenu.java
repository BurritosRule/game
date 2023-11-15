package com.github.game.menu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.github.game.world.Action;

public class InventoryMenu implements Menu {
  public String header;
  private final InventoryActions inventoryActions;
  private Collection<Action> additionalActions;

  private List<Action> possibleInput = new ArrayList<Action>();

  public InventoryMenu(InventoryActions inventoryActions) {
    this.header = "Inventory Menu\n----------------------";
    this.inventoryActions = inventoryActions;
  }

  @Override
  public void addActions(Collection<Action> additionalActions) {
    this.additionalActions = additionalActions;
  }

  @Override
  public String header() {
    return header;
  }

  @Override
  public List<Action> possibleInput() {
    // List<Action> possibleInput = optionActions.getActions();
    // List<Action> possibleInput = new ArrayList<Action>();
    possibleInput.add(inventoryActions);
    if (additionalActions.size() > 0) {
      possibleInput.addAll(additionalActions);
    }

    return possibleInput;
  }
}
