package me.kauepalota.hexagonaltemplate.infrastructure.notification.strategies;

import me.kauepalota.hexagonaltemplate.domain.model.Notification;
import org.springframework.stereotype.Service;

@Service
public class PushNotificationStrategy implements NotificationStrategy {
    @Override
    public void send(Notification notification) {
        System.out.println("Sending push notification: " + notification.getPushProperties().pushSpecificProperty());
    }
}
