package me.kauepalota.hexagonaltemplate.domain.model.campaign;

import lombok.Builder;
import me.kauepalota.hexagonaltemplate.domain.model.event.MessageEvent;

import java.util.Set;
import java.util.UUID;

/**
 * Should probably come from a library (containing domain layer)
 * across the two pieces.
 */
@Builder
public record Campaign(
    UUID id,
    String name,

    Set<CampaignCondition> conditions

    // Another fields...
) {
    public boolean isMeetingConditions(MessageEvent event) {
        return conditions.stream()
            .allMatch(condition -> condition.evaluate(
                event.getPropertyValue(condition.fieldName())
            ));
    }
}
