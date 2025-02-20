package me.kauepalota.hexagonaltemplate.domain.model.campaign;

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