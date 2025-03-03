package me.kauepalota.hexagonaltemplate.domain.model.campaign.condition;

import me.kauepalota.hexagonaltemplate.domain.model.campaign.CampaignCondition;

public class NumberConditionEvaluator implements ConditionEvaluator<Number> {
    @Override
    public boolean evaluate(Number value, CampaignCondition condition) {
        return false;
    }
}
