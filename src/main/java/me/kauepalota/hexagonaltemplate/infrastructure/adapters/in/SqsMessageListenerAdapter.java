package me.kauepalota.hexagonaltemplate.infrastructure.adapters.in;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import me.kauepalota.hexagonaltemplate.domain.model.event.MessageEvent;
import me.kauepalota.hexagonaltemplate.domain.ports.in.EventHandlerPort;
import me.kauepalota.hexagonaltemplate.infrastructure.dto.SqsInputDto;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SqsMessageListenerAdapter {
    private final EventHandlerPort handler;

    private final ObjectMapper mapper;

    @SqsListener
    public void onMessage(String message) {
        SqsInputDto input = mapper.convertValue(message, SqsInputDto.class);

        handler.handle(toDomain(input));
    }

    private MessageEvent toDomain(SqsInputDto sqsInputDto) {
        return new MessageEvent(sqsInputDto.userId(), sqsInputDto.type());
    }
}
