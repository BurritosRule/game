package com.github.game.state;

import java.io.*;

public class GameStatePersistence {

  public static void saveToFile(GameState gameState, String filename) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
      writer.write("playerLocation=" + gameState.getPlayerLocation() + "\n");
      writer.write("chestState=" + gameState.getChestState() + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void loadFromFile(GameState gameState, String filename) {
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.startsWith("playerLocation=")) {
          gameState.setPlayerLocation(
              com.github.game.world.LocationName.valueOf(line.substring("playerLocation=".length())));
        } else if (line.startsWith("chestState=")) {
          gameState.setChestState(line.substring("chestState=".length()));
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}