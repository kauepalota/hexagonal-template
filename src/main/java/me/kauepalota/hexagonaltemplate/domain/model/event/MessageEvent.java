package me.kauepalota.hexagonaltemplate.domain.model.event;

import me.kauepalota.hexagonaltemplate.domain.enums.MessageDestinationType;

import java.util.Set;
import java.util.UUID;

public record MessageEvent(
    UUID userId,
    MessageDestinationType type,

    Set<MessageEventProperty> properties

    // Another fields
) {}
