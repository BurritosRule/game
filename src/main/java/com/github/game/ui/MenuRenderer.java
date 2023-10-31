package com.github.game.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jline.terminal.Terminal;

import com.github.game.menu.Menu;
import com.github.game.world.Action;

public class MenuRenderer {
  private final Terminal terminal;

  public MenuRenderer(Terminal terminal) {
    this.terminal = terminal;
  }

  public Map<String, Action> render(Menu menu) {

    List<Action> possibleInput = null;

    possibleInput = menu.possibleInput();

    StringBuilder keywords = new StringBuilder();

    Map<String, Action> actions = new HashMap<>();
    for (Action action : possibleInput) {
      keywords.append(action.getKeyword()).append("\n");
      actions.put(action.getKeyword(), action);
    }

    terminal.writer().println(menu.header());
    terminal.writer().println("\n" + keywords);
    return actions;

  }
}
