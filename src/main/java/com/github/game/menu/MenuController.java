package com.github.game.menu;

import com.github.game.world.Action;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MenuController {
  private Deque<Menu> menuDeque = new ArrayDeque<>();

  public void addMenu(Menu menu) {
    if (menu == null) {
      System.err.println("Warning: Tried to add a null menu to the menu controller. Ignoring.");
      return;
    }
    // Only add global actions (Options, Back) via addActions
    List<Action> globalActions = new ArrayList<>();
    globalActions.add(new OptionsMenuAction(this, null));
    if (isBackEnabled()) {
      globalActions.add(new BackAction(this));
    }
    // Merge with any existing additional actions
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
