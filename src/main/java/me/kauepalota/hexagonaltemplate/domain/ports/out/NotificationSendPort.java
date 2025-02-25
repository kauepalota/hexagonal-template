package me.kauepalota.hexagonaltemplate.domain.ports.out;

import me.kauepalota.hexagonaltemplate.domain.model.Notification;

public interface NotificationSendPort {
    void sendNotification(Notification notification);
}
