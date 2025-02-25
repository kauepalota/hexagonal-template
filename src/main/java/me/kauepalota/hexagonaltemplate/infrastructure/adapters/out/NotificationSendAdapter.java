package me.kauepalota.hexagonaltemplate.infrastructure.adapters.out;

import me.kauepalota.hexagonaltemplate.domain.enums.NotificationType;
import me.kauepalota.hexagonaltemplate.domain.model.Notification;
import me.kauepalota.hexagonaltemplate.domain.ports.out.NotificationSendPort;
import me.kauepalota.hexagonaltemplate.infrastructure.notification.strategies.NotificationStrategy;
import me.kauepalota.hexagonaltemplate.infrastructure.notification.strategies.PushNotificationStrategy;
import me.kauepalota.hexagonaltemplate.infrastructure.notification.strategies.WhatsappNotificationStrategy;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class NotificationSendAdapter implements NotificationSendPort {
    private final Map<NotificationType, NotificationStrategy> strategies;

    public NotificationSendAdapter(
        WhatsappNotificationStrategy whatsappStrategy,
        PushNotificationStrategy pushStrategy
    ) {
        this.strategies = Map.of(
            NotificationType.WHATSAPP, whatsappStrategy,
            NotificationType.PUSH, pushStrategy
        );
    }


    @Override
    public void sendNotification(Notification notification) {
        NotificationStrategy strategy = strategies.get(notification.type());
        if (strategy == null) {
            throw new UnsupportedOperationException("Unsupported notification type: " + notification.type());
        }

        strategy.send(notification);
    }
}
