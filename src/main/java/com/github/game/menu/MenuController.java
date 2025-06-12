package com.github.game.menu;

import com.github.game.world.Action;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MenuController {
  private Deque<Menu> menuDeque = new ArrayDeque<>();

  public void addMenu(Menu menu) {
    List<Action> globalActions = new ArrayList<>();
    globalActions.add(new OptionsMenuAction(this, null)); // Add Options to all menus
    if (isBackEnabled()) {
      globalActions.add(new BackAction(this));
    }
    menu.addActions(globalActions);
    menuDeque.add(menu);
  }

  public Menu popMenu() {
    return menuDeque.pop();
  }

  public Menu removeLastMenu() {
    return menuDeque.removeLast();
  }

  public Menu peekMenu() {
    return menuDeque.peek();
  }

  public Menu peekLastMenu() {
    return menuDeque.peekLast();
  }

  public boolean isBackEnabled() {
    return menuDeque.size() > 1;
  }

  public void clearMenu() {
    menuDeque.clear();
  }
}
