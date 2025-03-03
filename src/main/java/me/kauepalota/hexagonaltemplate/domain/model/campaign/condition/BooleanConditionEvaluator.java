package me.kauepalota.hexagonaltemplate.domain.model.campaign.condition;

import me.kauepalota.hexagonaltemplate.domain.model.campaign.CampaignCondition;

public class BooleanConditionEvaluator implements ConditionEvaluator<Boolean> {
    @Override
    public boolean evaluate(Boolean value, CampaignCondition condition) {
        if (!condition.isBooleanValue()) {
            return false;
        }

        switch (condition.operation()) {
            case EQUALS -> {
                return condition.value() == value;
            }

            case NOT_EQUALS -> {
                return condition.value() != value;
            }

            default -> {
                return false;
            }
        }
    }
}
