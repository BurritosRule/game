package com.github.game.state;

import java.io.*;
import java.util.Map;
import com.github.game.world.Persistable;

public class GameStatePersistence {

  public static void saveToFile(GameState gameState, String filename) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
      for (Map.Entry<String, Persistable> entry : gameState.getAllState().entrySet()) {
        writer.write(entry.getKey() + "=" + entry.getValue().serialize() + "\n");
      }
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
          int idx = line.indexOf('=');
          if (idx > 0) {
            String key = line.substring(0, idx);
            String value = line.substring(idx + 1);
            Persistable obj = gameState.getState(key);
            if (obj != null) {
              obj.deserialize(value);
            }
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