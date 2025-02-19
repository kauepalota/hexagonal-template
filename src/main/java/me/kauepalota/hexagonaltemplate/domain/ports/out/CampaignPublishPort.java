package me.kauepalota.hexagonaltemplate.domain.ports.out;

import me.kauepalota.hexagonaltemplate.domain.model.campaign.Campaign;
import me.kauepalota.hexagonaltemplate.domain.model.event.MessageEvent;

import java.util.List;

public interface CampaignPublishPort {
    void publishCampaigns(MessageEvent event, List<Campaign> campaigns);
}
