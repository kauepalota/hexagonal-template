package me.kauepalota.hexagonaltemplate.domain.model;

import me.kauepalota.hexagonaltemplate.domain.enums.NotificationType;
import me.kauepalota.hexagonaltemplate.domain.model.properties.NotificationProperties;
import me.kauepalota.hexagonaltemplate.domain.model.properties.PushProperties;
import me.kauepalota.hexagonaltemplate.domain.model.properties.WhatsappProperties;

import java.util.UUID;

public record Notification(
    UUID userId,
    NotificationType type,

    NotificationProperties properties

    // Another fields
) {
    public Notification {
        if (type == NotificationType.PUSH && !(properties instanceof PushProperties)) {
            throw new IllegalArgumentException("Properties must be of type PushProperties");
        }

        if (type == NotificationType.WHATSAPP && !(properties instanceof WhatsappProperties)) {
            throw new IllegalArgumentException("Properties must be of type WhatsappProperties");
        }
    }

    public boolean isPushNotification() {
        return type == NotificationType.PUSH;
    }

    public boolean isWhatsappNotification() {
        return type == NotificationType.WHATSAPP;
    }

    public WhatsappProperties getWhatsappProperties() {
        if (!isWhatsappNotification()) {
            throw new IllegalStateException("Notification is not a Whatsapp notification");
        }

        return (WhatsappProperties) properties;
    }

    public PushProperties getPushProperties() {
        if (!isPushNotification()) {
            throw new IllegalStateException("Notification is not a Push notification");
        }

        return (PushProperties) properties;
    }
}
