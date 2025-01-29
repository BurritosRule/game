package com.github.game.world;

import com.google.common.eventbus.EventBus;

// This setup ensures a thread-safe, lazily-initialized singleton.
// Check with Greg because I don't trust AI.
public class EventBusSingleton {

  private static class Holder {
    private static final EventBus INSTANCE = new EventBus();
  }

  private EventBusSingleton() {
    // Prevent instantiation
  }

  public static EventBus getInstance() {
    return Holder.INSTANCE;
  }
}