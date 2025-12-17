package com.github.game.state;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Marker interface for persistable state objects.
 * Jackson will automatically include type information when serializing.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public interface Persistable {
  // Marker interface - type info handled by Jackson
}
