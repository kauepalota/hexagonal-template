package me.kauepalota.hexagonaltemplate.domain.model.campaign;

import lombok.Builder;

import java.util.Set;

/**
 * Represents a condition for a campaign based on a field, an operation, and a value.
 *
 * <p>The condition is used to evaluate if a property value meets the criteria defined by the operation.</p>
 */
@Builder
public record CampaignCondition(String fieldName, CampaignOperation operation, Object value) {
    private static final Set<Class<?>> ALLOWED_TYPES = Set.of(Boolean.class, String.class, Number.class);

    public CampaignCondition {
        if (fieldName == null) {
            throw new NullPointerException("fieldName is null");
        }

        if (operation == null) {
            throw new NullPointerException("operation is null");
        }

        if (value == null) {
            throw new NullPointerException("value is null");
        }

        if (!ALLOWED_TYPES.contains(value.getClass())) {
            throw new IllegalArgumentException("value is not allowed for type " + value.getClass());
        }
    }

    public boolean isBooleanValue() {
        return value instanceof Boolean;
    }

    public boolean isStringValue() {
        return value instanceof String;
    }

    public boolean isNumberValue() {
        return value instanceof Number;
    }
}