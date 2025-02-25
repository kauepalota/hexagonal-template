package me.kauepalota.hexagonaltemplate.infrastructure.notification.dto;

import me.kauepalota.hexagonaltemplate.domain.enums.NotificationType;

import java.util.UUID;

public record WhatsappNotificationDto(
    UUID userId,
    NotificationType type,

    String whatsappSpecificField

    // Another fields
) {}
