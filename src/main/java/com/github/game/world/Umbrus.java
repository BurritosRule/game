package com.github.game.world;

import java.util.List;

public class Umbrus implements Town {

  @Override
  public List<Action> getActions() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getActions'");
  }

  @Override
  public String getName() {
    return "Umbrus";
  }

  @Override
  public String getSubLocation() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getSubLocation'");
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
