package br.globo.desafio.ocartaxo.dto;


import br.globo.desafio.ocartaxo.dto.NotificationRequest;

import java.io.Serializable;


public class NotificationRequest implements Serializable {

    private NotificationType notificationType;
    private String subscription;

    public NotificationRequest(NotificationType notificationType, String subscription) {
        this.notificationType = notificationType;
        this.subscription = subscription;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public String getSubscription() {
        return subscription;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Tipo Notificação: ");
        sb.append(notificationType);
        sb.append(" | ");
        sb.append("Subscription: ");
        sb.append(subscription);

        return sb.toString();
    }
}
