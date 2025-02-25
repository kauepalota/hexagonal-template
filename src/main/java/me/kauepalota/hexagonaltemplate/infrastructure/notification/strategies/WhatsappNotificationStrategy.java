package me.kauepalota.hexagonaltemplate.infrastructure.notification.strategies;

import me.kauepalota.hexagonaltemplate.domain.enums.NotificationType;
import me.kauepalota.hexagonaltemplate.domain.model.Notification;
import org.springframework.stereotype.Service;

@Service
public class WhatsappNotificationStrategy implements NotificationStrategy {
    @Override
    public void send(Notification notification) {
        validate(notification, NotificationType.WHATSAPP);

        System.out.println("Sending whatsapp notification: " + notification.getWhatsappProperties().whatsappSpecificProperty());
    }
}
