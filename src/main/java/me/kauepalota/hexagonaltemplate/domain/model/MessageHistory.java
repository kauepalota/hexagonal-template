package me.kauepalota.hexagonaltemplate.domain.model;

import me.kauepalota.hexagonaltemplate.domain.model.event.MessageEvent;

import java.time.LocalDateTime;
import java.util.UUID;

public record MessageHistory(
    UUID userId,
    LocalDateTime creationDate,

    MessageEvent event

    // Another fields
) {}