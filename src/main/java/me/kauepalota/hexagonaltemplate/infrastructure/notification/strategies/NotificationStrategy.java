package me.kauepalota.hexagonaltemplate.infrastructure.notification.strategies;

import me.kauepalota.hexagonaltemplate.domain.model.Notification;

public interface NotificationStrategy {
    void send(Notification notification);
}
