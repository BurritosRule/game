package com.github.game.state;

import com.google.common.eventbus.EventBus;
import javax.annotation.Nonnull;
import com.github.game.world.DomainEvent;
import com.github.game.world.DomainEventPublisher;

public class GuavaEventBusPublisher implements DomainEventPublisher {
  private final EventBus eventBus;

  public GuavaEventBusPublisher(EventBus eventBus) {
    this.eventBus = eventBus;
  }

  @Override
  public void publish(@Nonnull DomainEvent event) {
    eventBus.post(event);
  }
}
