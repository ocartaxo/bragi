package br.globo.desafio.ocartaxo.dto;

import org.springframework.stereotype.Component;

@Component
public enum NotificationType {
    SUBSCRIPTION_PURCHASED,
    SUBSCPRITION_CANCELED,
    SUBSCPRITION_RESTARTED
}
