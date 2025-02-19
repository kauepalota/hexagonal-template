package me.kauepalota.hexagonaltemplate.domain.ports.in;

import me.kauepalota.hexagonaltemplate.domain.model.event.MessageEvent;

public interface EventHandlerPort {
    void handle(MessageEvent event);
}
