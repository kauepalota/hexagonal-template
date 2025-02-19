package me.kauepalota.hexagonaltemplate.application.dto.sqs;

import me.kauepalota.hexagonaltemplate.domain.enums.MessageDestinationType;

import java.util.Set;
import java.util.UUID;

public record EventDto(
    UUID userId,
    MessageDestinationType type,

    Set<EventPropertyDto> properties

    // Another fields
) {}
