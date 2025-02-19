package me.kauepalota.hexagonaltemplate.application.adapters.in;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import me.kauepalota.hexagonaltemplate.application.dto.sqs.EventDto;
import me.kauepalota.hexagonaltemplate.application.dto.sqs.EventPropertyDto;
import me.kauepalota.hexagonaltemplate.domain.model.event.MessageEvent;
import me.kauepalota.hexagonaltemplate.domain.model.event.MessageEventProperty;
import me.kauepalota.hexagonaltemplate.domain.ports.in.EventHandlerPort;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SqsMessageListenerAdapter {
    private final EventHandlerPort handler;
    
    @SqsListener
    public void onMessage(EventDto dto) {
        handler.handle(toDomain(dto));
    }

    private MessageEvent toDomain(EventDto dto) {
        return new MessageEvent(
            dto.userId(),
            dto.type(),
            dto.properties().stream()
                .map(this::toDomain)
                .collect(Collectors.toSet())
        );
    }

    private MessageEventProperty toDomain(EventPropertyDto dto) {
        return new MessageEventProperty(dto.fieldName(), dto.value());
    }
}
