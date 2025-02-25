package me.kauepalota.hexagonaltemplate.infrastructure.notification.converters;

import me.kauepalota.hexagonaltemplate.domain.model.Notification;
import me.kauepalota.hexagonaltemplate.domain.model.properties.WhatsappProperties;
import me.kauepalota.hexagonaltemplate.infrastructure.notification.dto.WhatsappNotificationDto;
import org.springframework.stereotype.Service;

@Service
public class WhatsappNotificationConverter implements NotificationConverter<WhatsappNotificationDto> {
    @Override
    public Notification toDomain(WhatsappNotificationDto notificationEventDto) {
        return new Notification(
            notificationEventDto.userId(),
            notificationEventDto.type(),
            new WhatsappProperties(notificationEventDto.whatsappSpecificField())
        );
    }
}
