package com.github.game.ui;

import java.util.Map;

import org.jline.reader.LineReader;

import com.github.game.world.Action;

public class ActionExecuter {
  private final LineReader reader;

  public ActionExecuter(LineReader reader) {
    this.reader = reader;

  }

  public void executeAction(Map<String, Action> actions) {

    String keyword = reader.readLine("Action > ");
    actions.get(keyword).execute();

  }

}
