package me.kauepalota.hexagonaltemplate.infrastructure.adapters.out.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBGeneratedUuid;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@DynamoDBTable(tableName = "message_history")
@Builder
public class MessageHistoryEntity {
    @DynamoDBHashKey(attributeName="user_id")
    private UUID userId;

    @DynamoDBAttribute(attributeName="creation_date")
    private LocalDateTime creationDate;

    @DynamoDBAttribute(attributeName="event")
    private MessageEventEntity event;
}
