package me.kauepalota.hexagonaltemplate.domain.model.campaign;

/**
 * Represents a condition for a campaign based on a field, an operation, and a value.
 *
 * <p>The condition is used to evaluate if a property value meets the criteria defined by the operation.</p>
 */
public record CampaignCondition(String fieldName, String operation, double value) {
    public boolean evaluate(double propertyValue) {
        return switch (operation) {
            case ">" -> propertyValue > value;
            case ">=" -> propertyValue >= value;
            case "<" -> propertyValue < value;
            case "<=" -> propertyValue <= value;
            case "==" -> propertyValue == value;
            case "!=" -> propertyValue != value;
            default -> throw new IllegalArgumentException("Unknown operation: " + operation);
        };
    }
}