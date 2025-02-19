package me.kauepalota.hexagonaltemplate.application.services;

import me.kauepalota.hexagonaltemplate.domain.model.campaign.CampaignCondition;
import org.springframework.stereotype.Service;

@Service
public class CampaignEvaluationService {
    public boolean evaluateConditions(CampaignCondition condition, double currentValue) {
        return switch (condition.operation()) {
            case ">" -> currentValue > condition.value();
            case ">=" -> currentValue >= condition.value();
            case "<" -> currentValue < condition.value();
            case "<=" -> currentValue <= condition.value();
            case "=" -> currentValue == condition.value();
            default -> throw new IllegalArgumentException("Invalid operation");
        };
    }
}
