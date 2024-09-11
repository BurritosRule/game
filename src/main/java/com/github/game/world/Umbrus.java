package com.github.game.world;

import java.util.ArrayList;
import java.util.List;

public class Umbrus implements Town {

  @Override
  public List<Action> getActions() {
    List<Action> actions = new ArrayList<Action>();

    actions.add(new Action() {
      // TODO Refactor UI concern out of this class
      @Override
      public String getKeyword() {
        return "description";
      }

      @Override
      public void execute() {
        Umbrus.this.getDescription();
      }
    });

    return actions;
  }

  @Override
  public String getName() {
    return "Umbrus";
  }

  @Override
  public String getSubLocation() {
    return "Town Square";
  }

  @Override
  public String getDescription() {
    return "Umbrus is a town veiled in perpetual twilight, nestled within a dense forest of ancient trees.\n"
        + "Its darkened streets wind through shadowed canopies, where tall, looming buildings stand as silent sentinels against the encroaching darkness.\n"
        + "Residents live with a weariness born of living in a place where shadows hold sway,\n"
        + "yet amidst the whispers of forgotten secrets, a flicker of resilience remains—a spark of light\n"
        + "that refuses to be extinguished in the darkest of nights.\n";
  }

}
