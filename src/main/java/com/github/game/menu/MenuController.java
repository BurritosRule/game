package com.github.game.menu;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class MenuController {
  private Deque<Menu> menuDeque = new ArrayDeque<>();

  public void addMenu(Menu menu) {
    menuDeque.add(menu);
    if (isBackEnabled()) {
      menu.addActions(List.of(new BackAction(this)));
    }
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
