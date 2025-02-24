package me.kauepalota.hexagonaltemplate.infrastructure.adapters.out;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import me.kauepalota.hexagonaltemplate.domain.model.MessageHistory;
import me.kauepalota.hexagonaltemplate.domain.model.event.MessageEvent;
import me.kauepalota.hexagonaltemplate.domain.model.event.MessageEventProperty;
import me.kauepalota.hexagonaltemplate.domain.ports.out.HistoryRepositoryPort;
import me.kauepalota.hexagonaltemplate.infrastructure.adapters.out.entity.MessageEventEntity;
import me.kauepalota.hexagonaltemplate.infrastructure.adapters.out.entity.MessageEventPropertyEntity;
import me.kauepalota.hexagonaltemplate.infrastructure.adapters.out.entity.MessageHistoryEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class DynamoDbHistoryAdapter implements HistoryRepositoryPort {
    private final AmazonDynamoDB client = AmazonDynamoDBClient.builder()
        .build();

    private final DynamoDBMapper mapper = new DynamoDBMapper(client);

    @Override
    public MessageHistory getHistory(UUID userId) {
        final MessageHistoryEntity entity = mapper.load(MessageHistoryEntity.class, userId);
        if (entity != null) {
            return toDomain(entity);
        }

        return null;
    }

    @Override
    public void saveHistory(MessageHistory history) {
        mapper.save(toEntity(history));
    }

    private MessageHistory toDomain(MessageHistoryEntity entity) {
        return new MessageHistory(
            entity.getUserId(),
            entity.getCreationDate(),
            new MessageEvent(
                entity.getUserId(),
                entity.getEvent().getType(),
                entity.getEvent().getProperties().stream()
                    .map(prop -> new MessageEventProperty(
                        prop.getFieldName(),
                        prop.getValue()
                    )).collect(Collectors.toSet())
            )
        );
    }

    private MessageHistoryEntity toEntity(MessageHistory history) {
        return MessageHistoryEntity.builder()
            .userId(history.userId())
            .creationDate(history.creationDate())
            .event(new MessageEventEntity(
                history.event().type(),
                history.event().properties().stream()
                    .map(prop -> new MessageEventPropertyEntity(
                        prop.fieldName(),
                        prop.value()
                    )).collect(Collectors.toSet())
            )).build();
    }
}
