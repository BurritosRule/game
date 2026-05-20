package com.github.game.world;

import javax.annotation.Nonnull;

public interface DomainEventPublisher {
  void publish(@Nonnull DomainEvent event);
}
