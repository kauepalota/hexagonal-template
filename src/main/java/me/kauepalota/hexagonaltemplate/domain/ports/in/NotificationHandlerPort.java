package me.kauepalota.hexagonaltemplate.domain.ports.in;

import me.kauepalota.hexagonaltemplate.domain.model.Notification;

public interface NotificationHandlerPort {
    void handle(Notification notification);
}
