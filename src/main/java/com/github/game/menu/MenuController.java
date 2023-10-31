package com.github.game.menu;

import java.util.ArrayDeque;
import java.util.Deque;

public class MenuController {
  private Deque<Menu> menuDeque = new ArrayDeque<>();

  public void addMenu(Menu menu) {
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
}
