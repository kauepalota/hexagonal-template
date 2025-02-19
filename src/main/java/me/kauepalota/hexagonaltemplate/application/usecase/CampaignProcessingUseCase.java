package me.kauepalota.hexagonaltemplate.application.usecase;

import lombok.RequiredArgsConstructor;
import me.kauepalota.hexagonaltemplate.application.services.CampaignEvaluationService;
import me.kauepalota.hexagonaltemplate.domain.model.event.MessageEvent;
import me.kauepalota.hexagonaltemplate.domain.model.MessageHistory;
import me.kauepalota.hexagonaltemplate.domain.model.campaign.Campaign;
import me.kauepalota.hexagonaltemplate.domain.model.campaign.conditions.CampaignCondition;
import me.kauepalota.hexagonaltemplate.domain.ports.out.CampaignProviderPort;
import me.kauepalota.hexagonaltemplate.domain.ports.in.EventHandlerPort;
import me.kauepalota.hexagonaltemplate.domain.ports.out.HistoryRepositoryPort;
import me.kauepalota.hexagonaltemplate.domain.ports.out.CampaignPublishPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CampaignProcessingUsecase implements EventHandlerPort {
    private final HistoryRepositoryPort historyRepo;

    private final CampaignProviderPort campaignProvider;

    private final CampaignPublishPort publisher;

    private final CampaignEvaluationService evaluationService;

    @Override
    public void handle(MessageEvent event) {
        // Use inbound and outbound ports here

        MessageHistory history = historyRepo.getHistory(event.userId());
        List<Campaign> campaigns = campaignProvider.getPotentialCampaigns(event.type());
        List<Campaign> eligible = filterEligibleCampaigns(event, campaigns);

        publisher.publishCampaigns(event, eligible);

        MessageHistory newHistory = new MessageHistory(
            history.userId(),
            LocalDateTime.now(),
            event
        );

        historyRepo.saveHistory(newHistory);
    }

    private List<Campaign> filterEligibleCampaigns(MessageEvent event, List<Campaign> campaigns) {
        return campaigns.stream()
            .filter(campaign -> isMeetingConditions(campaign, event))
            .toList();
    }

    private boolean isMeetingConditions(Campaign campaign, MessageEvent event) {
        for (CampaignCondition condition : campaign.conditions()) {
            boolean isMeeting = event.properties().stream()
                .filter(property -> property.fieldName().equals(condition.fieldName()))
                .findFirst()
                .map(property -> evaluationService.evaluateConditions(condition, property.value()))
                .orElse(false);

            if (!isMeeting) {
                return false;
            }
        }

        return true;
    }
}
