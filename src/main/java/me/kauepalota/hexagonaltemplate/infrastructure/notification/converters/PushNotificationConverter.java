package me.kauepalota.hexagonaltemplate.infrastructure.notification.converters;

import me.kauepalota.hexagonaltemplate.domain.model.Notification;
import me.kauepalota.hexagonaltemplate.domain.model.properties.PushProperties;
import me.kauepalota.hexagonaltemplate.infrastructure.notification.dto.PushNotificationDto;
import org.springframework.stereotype.Service;

@Service
public class PushNotificationConverter implements NotificationConverter<PushNotificationDto> {

    @Override
    public Notification toDomain(PushNotificationDto appEventDto) {
        return new Notification(
            appEventDto.userId(),
            appEventDto.type(),
            new PushProperties(appEventDto.pushSpecificField())
        );
    }
}
