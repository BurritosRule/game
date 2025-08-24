package com.github.game.world;

import com.github.game.state.GameState;

public class PersistableRegistry {
  public static void registerAll(GameState gameState) {
    // Register all persistable objects needed for deserialization
    if (gameState.getState("WindingPath") == null) {
      gameState.setState("WindingPath", new WindingPath());
    }
    // Add more persistables here as needed
  }
}
