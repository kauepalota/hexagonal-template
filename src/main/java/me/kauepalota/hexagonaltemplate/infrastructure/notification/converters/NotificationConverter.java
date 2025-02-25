package me.kauepalota.hexagonaltemplate.infrastructure.notification.converters;

import me.kauepalota.hexagonaltemplate.domain.model.Notification;

public interface NotificationConverter<DTO> {
    Notification toDomain(DTO dto);
}
