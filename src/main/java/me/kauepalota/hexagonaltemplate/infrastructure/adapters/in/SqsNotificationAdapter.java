package me.kauepalota.hexagonaltemplate.infrastructure.adapters.in;

import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import me.kauepalota.hexagonaltemplate.domain.model.Notification;
import me.kauepalota.hexagonaltemplate.domain.ports.in.NotificationHandlerPort;
import me.kauepalota.hexagonaltemplate.infrastructure.notification.converters.PushNotificationConverter;
import me.kauepalota.hexagonaltemplate.infrastructure.notification.converters.WhatsappNotificationConverter;
import me.kauepalota.hexagonaltemplate.infrastructure.notification.dto.PushNotificationDto;
import me.kauepalota.hexagonaltemplate.infrastructure.notification.dto.WhatsappNotificationDto;
import org.springframework.stereotype.Component;

/**
 * Adapter for processing SQS messages.
 * Receives DTO messages from the SQS queue and converts them to the domain model.
 */
@Component
@RequiredArgsConstructor
public class SqsNotificationAdapter {
    private final NotificationHandlerPort handler;

    private final PushNotificationConverter pushNotificationConverter;

    private final WhatsappNotificationConverter whatsappNotificationConverter;

    @SqsListener("push-notification-queue")
    public void receiveMessage(PushNotificationDto dto) {
        Notification notification = pushNotificationConverter.toDomain(dto);

        handler.handle(notification);
    }

    @SqsListener("whatsapp-notification-queue")
    public void receiveMessage(WhatsappNotificationDto dto) {
        Notification notification = whatsappNotificationConverter.toDomain(dto);

        handler.handle(notification);
    }
}
