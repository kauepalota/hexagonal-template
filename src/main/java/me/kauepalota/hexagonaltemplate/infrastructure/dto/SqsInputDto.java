package me.kauepalota.hexagonaltemplate.infrastructure.dto;

import me.kauepalota.hexagonaltemplate.domain.enums.MessageDestinationType;

import java.util.UUID;

public record SqsInputDto(
    UUID userId,
    MessageDestinationType type

    // Another fields
) {}
