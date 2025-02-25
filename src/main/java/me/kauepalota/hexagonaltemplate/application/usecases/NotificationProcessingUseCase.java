package me.kauepalota.hexagonaltemplate.application.usecases;

import lombok.RequiredArgsConstructor;
import me.kauepalota.hexagonaltemplate.domain.model.Notification;
import me.kauepalota.hexagonaltemplate.domain.ports.in.NotificationHandlerPort;
import me.kauepalota.hexagonaltemplate.domain.ports.out.NotificationSendPort;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationProcessingUseCase implements NotificationHandlerPort {
    private final NotificationSendPort notificationSendPort;

    @Override
    public void handle(Notification notification) {
        notificationSendPort.sendNotification(notification);
    }
}
