package com.github.game.state;

import java.io.*;

public class GameStatePersistence {

  public static void saveToFile(GameState gameState, String filename) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
      writer.write("playerLocation=" + gameState.getPlayerLocation() + "\n");
      writer.write("chestState=" + gameState.getChestState() + "\n");
    } catch (IOException e) {
      System.out.println("Error saving game state to '" + filename + "': " + e.getMessage());
      System.out.println("Please check file permissions or disk space and try again.");
    }
  }

  public static void loadFromFile(GameState gameState, String filename, org.jline.reader.LineReader reader) {
    boolean loaded = false;
    String currentFilename = filename;
    while (!loaded) {
      try (BufferedReader fileReader = new BufferedReader(new FileReader(currentFilename))) {
        String line;
        while ((line = fileReader.readLine()) != null) {
          if (line.startsWith("playerLocation=")) {
            gameState.setPlayerLocation(
                com.github.game.world.LocationName.valueOf(line.substring("playerLocation=".length())));
          } else if (line.startsWith("chestState=")) {
            gameState.setChestState(line.substring("chestState=".length()));
          }
        }
        loaded = true;
      } catch (FileNotFoundException e) {
        System.out.println("Save file not found: '" + currentFilename + "'.");
        String input = reader.readLine("Please enter the path to your save file (or leave blank to cancel): ");
        if (input == null || input.trim().isEmpty()) {
          System.out.println("Load cancelled.");
          break;
        }
        currentFilename = input.trim();
      } catch (IOException e) {
        System.out.println("Error loading game state from '" + currentFilename + "': " + e.getMessage());
        break;
      }
    }
  }
}