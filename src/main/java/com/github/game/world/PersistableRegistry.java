package com.github.game.world;

import com.github.game.state.GameState;

public class PersistableRegistry {
  public static void registerAll(GameState gameState) {
    if (gameState.getState("WindingPath") == null) {
      gameState.setState("WindingPath", new com.github.game.world.WindingPath());
    }
  }
}
