package me.kauepalota.hexagonaltemplate.domain.model.campaign.condition;

import me.kauepalota.hexagonaltemplate.domain.model.campaign.CampaignCondition;

public class StringConditionEvaluator implements ConditionEvaluator<String> {
    @Override
    public boolean evaluate(String value, CampaignCondition condition) {
        return false;
    }
}
