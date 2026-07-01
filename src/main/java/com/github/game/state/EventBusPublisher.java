package com.github.game.state;

import java.util.Objects;

import com.google.common.eventbus.EventBus;

public class EventBusPublisher implements DomainEventPublisher {
  private final EventBus eventBus = new EventBus();

  public void register(Object listener) {
    eventBus.register(Objects.requireNonNull(listener, "listener must not be null"));
  }

  @Override
  public void publish(Object event) {
    eventBus.post(Objects.requireNonNull(event, "event must not be null"));
  }
}
