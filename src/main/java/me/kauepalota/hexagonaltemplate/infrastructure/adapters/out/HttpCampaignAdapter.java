package me.kauepalota.hexagonaltemplate.infrastructure.adapters.out;

import me.kauepalota.hexagonaltemplate.domain.enums.MessageDestinationType;
import me.kauepalota.hexagonaltemplate.domain.model.campaign.Campaign;
import me.kauepalota.hexagonaltemplate.domain.ports.out.CampaignProviderPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HttpCampaignAdapter implements CampaignProviderPort {
    @Override
    public List<Campaign> getPotentialCampaigns(MessageDestinationType type) {
        // Fetch the API returning a DTO, and then convert to domain layer.

        return null;
    }
}
