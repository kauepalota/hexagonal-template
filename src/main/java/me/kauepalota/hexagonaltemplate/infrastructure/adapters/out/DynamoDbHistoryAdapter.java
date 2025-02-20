package me.kauepalota.hexagonaltemplate.infrastructure.adapters.out;

import me.kauepalota.hexagonaltemplate.domain.model.MessageHistory;
import me.kauepalota.hexagonaltemplate.domain.ports.out.HistoryRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DynamoDbHistoryAdapter implements HistoryRepositoryPort {
    @Override
    public MessageHistory getHistory(UUID userId) {
        // Query dynamodb here and remember that you have to maintain an entity layer, and then convert to domain.

        return null;
    }

    @Override
    public void saveHistory(MessageHistory history) {
        // Convert to entity layer and then save in dynamodb
    }
}
