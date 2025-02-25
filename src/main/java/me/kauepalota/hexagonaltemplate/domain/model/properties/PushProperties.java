package me.kauepalota.hexagonaltemplate.domain.model.properties;

public record PushProperties(
    String pushSpecificProperty
) implements NotificationProperties {}
