package com.github.game.state;

import com.github.game.world.Chest;
import com.github.game.world.ChestPersistenceUtil;
import java.io.IOException;

public class ChestPersistenceAdapter {
  public static String saveChest(Chest chest, String chestId) {
    try {
      return ChestPersistenceUtil.serializeChest(chest, chestId);
    } catch (IOException e) {
      throw new RuntimeException("Failed to serialize chest state", e);
    }
  }

  public static void loadChest(Chest chest, String json) {
    try {
      ChestPersistenceUtil.applyChestState(chest, json);
    } catch (IOException e) {
      throw new RuntimeException("Failed to deserialize chest state", e);
    }
  }
}
