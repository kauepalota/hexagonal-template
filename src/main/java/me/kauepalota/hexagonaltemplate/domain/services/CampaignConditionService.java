package me.kauepalota.hexagonaltemplate.domain.services;

import me.kauepalota.hexagonaltemplate.domain.model.campaign.CampaignCondition;
import me.kauepalota.hexagonaltemplate.domain.model.campaign.condition.BooleanConditionEvaluator;
import me.kauepalota.hexagonaltemplate.domain.model.campaign.condition.NumberConditionEvaluator;
import me.kauepalota.hexagonaltemplate.domain.model.campaign.condition.StringConditionEvaluator;

public class CampaignConditionService {
    private final BooleanConditionEvaluator booleanEvaluator = new BooleanConditionEvaluator();
    private final StringConditionEvaluator stringEvaluator = new StringConditionEvaluator();
    private final NumberConditionEvaluator numberEvaluator = new NumberConditionEvaluator();

    public <T> boolean evaluateCondition(T value, CampaignCondition condition) {
        if (value instanceof Number) {
            return numberEvaluator.evaluate((Number) value, condition);
        } else if (value instanceof String) {
            return stringEvaluator.evaluate((String) value, condition);
        } else if (value instanceof Boolean) {
            return booleanEvaluator.evaluate((Boolean) value, condition);
        }

        return false;
    }
}
