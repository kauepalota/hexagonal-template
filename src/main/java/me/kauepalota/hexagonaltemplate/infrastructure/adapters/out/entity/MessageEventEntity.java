package me.kauepalota.hexagonaltemplate.infrastructure.adapters.out.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import lombok.AllArgsConstructor;
import lombok.Data;
import me.kauepalota.hexagonaltemplate.domain.enums.MessageDestinationType;

import java.util.Set;

@Data
@AllArgsConstructor
public class MessageEventEntity {
    @DynamoDBAttribute(attributeName="destination_type")
    private MessageDestinationType type;

    @DynamoDBAttribute(attributeName="properties")
    private Set<MessageEventPropertyEntity> properties;
}
