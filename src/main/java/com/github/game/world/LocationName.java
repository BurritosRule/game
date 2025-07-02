package com.github.game.world;

public enum LocationName {
  UMBRUS,
  WINDING_PATH,
  TOWER;

  public String getDisplayName() {
    // Convert the enum name to a title-cased format
    String[] words = name().toLowerCase().split("_");
    StringBuilder titleCasedName = new StringBuilder();
    for (String word : words) {
      titleCasedName.append(Character.toUpperCase(word.charAt(0)))
          .append(word.substring(1))
          .append(" ");
    }
    return titleCasedName.toString().trim();
  }

}
