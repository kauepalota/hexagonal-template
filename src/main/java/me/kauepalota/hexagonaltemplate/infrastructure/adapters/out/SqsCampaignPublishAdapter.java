package me.kauepalota.hexagonaltemplate.infrastructure.adapters.out;

import lombok.RequiredArgsConstructor;
import me.kauepalota.hexagonaltemplate.domain.model.campaign.Campaign;
import me.kauepalota.hexagonaltemplate.domain.model.event.MessageEvent;
import me.kauepalota.hexagonaltemplate.domain.ports.out.CampaignPublishPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SqsCampaignPublishAdapter implements CampaignPublishPort {
    @Override
    public void publishCampaigns(MessageEvent event, List<Campaign> campaigns) {
        campaigns.forEach(campaign -> {
            // Send to each SQS based on destination
        });
    }
}
