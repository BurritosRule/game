package com.github.game.world;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UmbrusFilePersistence {
  private static final String SAVE_PATH = "umbrusstate.json";

  public static void saveUmbrusToFile(Umbrus umbrus) {
    String json;
    try {
      json = UmbrusPersistenceUtil.serializeUmbrus(umbrus);
    } catch (IOException e) {
      throw new RuntimeException("Failed to serialize Umbrus state", e);
    }
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(SAVE_PATH))) {
      writer.write(json);
    } catch (IOException e) {
      throw new RuntimeException("Failed to write Umbrus state to file", e);
    }
  }

  public static void loadUmbrusFromFile(Umbrus umbrus) {
    Path path = Paths.get(SAVE_PATH);
    if (!Files.exists(path)) {
      // File does not exist, skip loading and use default state
      return;
    }
    try {
      String json = new String(Files.readAllBytes(path));
      UmbrusPersistenceUtil.applyUmbrusState(umbrus, json);
    } catch (IOException e) {
      throw new RuntimeException("Failed to read Umbrus state from file", e);
    }
  }
}
