package me.kauepalota.hexagonaltemplate.infrastructure.notification.dto;

import me.kauepalota.hexagonaltemplate.domain.enums.NotificationType;

import java.util.UUID;

public record PushNotificationDto(
    UUID userId,
    NotificationType type,

    String pushSpecificField

    // Another fields
) {}
