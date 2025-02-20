package me.kauepalota.hexagonaltemplate.infrastructure.adapters.out;

import me.kauepalota.hexagonaltemplate.domain.enums.MessageDestinationType;
import me.kauepalota.hexagonaltemplate.domain.model.campaign.Campaign;
import me.kauepalota.hexagonaltemplate.domain.model.campaign.CampaignCondition;
import me.kauepalota.hexagonaltemplate.domain.model.campaign.CampaignOperation;
import me.kauepalota.hexagonaltemplate.domain.ports.out.CampaignProviderPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Component
public class HttpCampaignAdapter implements CampaignProviderPort {
    @Override
    public List<Campaign> getPotentialCampaigns(MessageDestinationType type) {
        // Fetch the API returning a DTO, and then convert to domain layer.

        return List.of(
            Campaign.builder()
                .id(UUID.randomUUID())
                .name("Verão")
                .conditions(Set.of(
                    CampaignCondition.builder()
                        .fieldName("age")
                        .operation(CampaignOperation.GREATER_THAN)
                        .value(18)
                        .build(),
                    CampaignCondition.builder()
                        .fieldName("limit")
                        .operation(CampaignOperation.GREATER_THAN)
                        .value(1000)
                        .build())
                ).build()
        );
    }
}
