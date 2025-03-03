package me.kauepalota.hexagonaltemplate.domain.model.campaign;

import lombok.Builder;
import me.kauepalota.hexagonaltemplate.domain.model.event.MessageEvent;
import me.kauepalota.hexagonaltemplate.domain.services.CampaignConditionService;

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
    private static final CampaignConditionService CONDITION_SERVICE = new CampaignConditionService();

    public boolean isMeetingConditions(MessageEvent event) {
        return conditions.stream()
                .allMatch(condition -> CONDITION_SERVICE.evaluateCondition(
                        event.getPropertyValue(condition.fieldName()), condition
                ));
    }
}
