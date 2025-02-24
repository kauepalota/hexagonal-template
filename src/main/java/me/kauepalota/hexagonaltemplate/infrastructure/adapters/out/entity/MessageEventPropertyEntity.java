package me.kauepalota.hexagonaltemplate.infrastructure.adapters.out.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageEventPropertyEntity {
    @DynamoDBAttribute(attributeName="field_name")
    private String fieldName;

    @DynamoDBAttribute(attributeName="value")
    private Double value;
}
