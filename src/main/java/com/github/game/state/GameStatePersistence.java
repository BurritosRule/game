package com.github.game.state;

import java.io.*;
import java.util.Map;

public class GameStatePersistence {

  public static void saveToFile(GameState gameState, String filename) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
      for (Map.Entry<String, Object> entry : gameState.getAllState().entrySet()) {
        // Only save objects that have legacy serialize method
        try {
          java.lang.reflect.Method serialize = entry.getValue().getClass().getMethod("serialize");
          Object result = serialize.invoke(entry.getValue());
          writer.write(entry.getKey() + "=" + result + "\n");
        } catch (Exception e) {
          // Not a legacy persistable, skip
        }
      }
    } catch (IOException e) {
      System.out.println("Error saving game state to '" + filename + "': " + e.getMessage());
      System.out.println("Please check file permissions or disk space and try again.");
    }
  }

  public static void loadFromFile(GameState gameState, String filename, org.jline.reader.LineReader reader) {
    File file = new File(filename);
    if (!file.exists()) {
      System.out.println("No save file found: '" + filename + "'. Starting with default state.");
      return;
    }
    try (BufferedReader fileReader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = fileReader.readLine()) != null) {
        int idx = line.indexOf('=');
        if (idx > 0) {
          String key = line.substring(0, idx);
          String value = line.substring(idx + 1);
          Object obj = gameState.getState(key);
          try {
            java.lang.reflect.Method deserialize = obj.getClass().getMethod("deserialize", String.class);
            deserialize.invoke(obj, value);
          } catch (Exception e) {
            // Not a legacy persistable, skip
          }
        }
      }
    } catch (IOException e) {
      System.out.println("Error loading game state from '" + filename + "': " + e.getMessage());
    }
  }

  // NOTE: PlayerState is now handled by PlayerStateFilePersistence and not by
  // this class.
}