package br.globo.desafio.ocartaxo.dto;

import br.globo.desafio.ocartaxo.dto.NotificationType;

import java.time.LocalDateTime;

public class EventHistoryDTO {

    private String subscriptionId;
    private NotificationType notificationType;
    private LocalDateTime createdAt;


    public EventHistoryDTO(String subscriptionId, NotificationType notificationType, LocalDateTime createdAt) {
        this.subscriptionId = subscriptionId;
        this.notificationType = notificationType;
        this.createdAt = createdAt;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
