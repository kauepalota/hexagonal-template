package me.kauepalota.hexagonaltemplate.domain.ports.out;

import me.kauepalota.hexagonaltemplate.domain.enums.MessageDestinationType;
import me.kauepalota.hexagonaltemplate.domain.model.campaign.Campaign;

import java.util.List;

public interface CampaignProviderPort {
    List<Campaign> getPotentialCampaigns(MessageDestinationType type);
}
