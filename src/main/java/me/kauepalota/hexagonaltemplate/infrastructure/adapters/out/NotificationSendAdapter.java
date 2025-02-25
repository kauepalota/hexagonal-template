package me.kauepalota.hexagonaltemplate.infrastructure.adapters.out;

import lombok.RequiredArgsConstructor;
import me.kauepalota.hexagonaltemplate.domain.model.Notification;
import me.kauepalota.hexagonaltemplate.domain.ports.out.NotificationSendPort;
import me.kauepalota.hexagonaltemplate.infrastructure.notification.strategies.PushNotificationStrategy;
import me.kauepalota.hexagonaltemplate.infrastructure.notification.strategies.WhatsappNotificationStrategy;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationSendAdapter implements NotificationSendPort {
    private final WhatsappNotificationStrategy whatsappStrategy;

    private final PushNotificationStrategy pushStrategy;

    @Override
    public void sendNotification(Notification notification) {
        switch (notification.type()) {
            case WHATSAPP:
                whatsappStrategy.send(notification);
                break;
            case PUSH:
                pushStrategy.send(notification);
                break;
            case EMAIL:
                System.out.println("TODO: Implement email notification");
                break;
        }
    }
}
