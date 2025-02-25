package me.kauepalota.hexagonaltemplate.infrastructure.notification.strategies;

import me.kauepalota.hexagonaltemplate.domain.enums.NotificationType;
import me.kauepalota.hexagonaltemplate.domain.model.Notification;

public interface NotificationStrategy {
    void send(Notification notification);

    default void validate(Notification notification, NotificationType type) {
        if (notification.type() != type) {
            throw new IllegalArgumentException("Invalid notification type");
        }
    }
}
