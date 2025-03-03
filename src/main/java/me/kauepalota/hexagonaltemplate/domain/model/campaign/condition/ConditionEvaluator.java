package me.kauepalota.hexagonaltemplate.domain.model.campaign.condition;

import me.kauepalota.hexagonaltemplate.domain.model.campaign.CampaignCondition;

public interface ConditionEvaluator<T> {
    boolean evaluate(T value, CampaignCondition condition);
}
