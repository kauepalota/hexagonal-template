package me.kauepalota.hexagonaltemplate.domain.model.campaign;

import java.util.Set;
import java.util.UUID;

/**
 * Should probably come from a library (containing domain layer)
 * across the two pieces.
 */
public record Campaign(
    UUID id,
    String name,

    Set<CampaignCondition> conditions

    // Another fields...
) {}
