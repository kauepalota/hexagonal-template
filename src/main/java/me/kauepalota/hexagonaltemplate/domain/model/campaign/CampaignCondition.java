package me.kauepalota.hexagonaltemplate.domain.model.campaign;

import lombok.Builder;

/**
 * Represents a condition for a campaign based on a field, an operation, and a value.
 *
 * <p>The condition is used to evaluate if a property value meets the criteria defined by the operation.</p>
 */
@Builder
public record CampaignCondition(String fieldName, CampaignOperation operation, double value) {
    public boolean evaluate(double propertyValue) {
        return switch (operation) {
            case GREATER_THAN -> propertyValue > value;
            case GREATER_THAN_OR_EQUALS -> propertyValue >= value;
            case LESS_THAN -> propertyValue < value;
            case LESS_THAN_OR_EQUALS -> propertyValue <= value;
            case EQUALS -> propertyValue == value;
            case NOT_EQUALS -> propertyValue != value;
        };
    }
}