package me.kauepalota.hexagonaltemplate.domain.ports.out;

import me.kauepalota.hexagonaltemplate.domain.model.MessageHistory;

import java.util.UUID;

public interface HistoryRepositoryPort {
    MessageHistory getHistory(UUID userId);

    void saveHistory(MessageHistory history);
}
