package com.github.game.state;

public interface DomainEventPublisher {
  void publish(Object event);
}
