package br.globo.desafio.ocartaxo.subscription;

import br.globo.desafio.ocartaxo.dto.NotificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class NotifcationFactory {

    private Map<String, Notification> notificationStrategies;

    @Autowired
    public NotifcationFactory(Map<String, Notification> notificationStrategies) {
        this.notificationStrategies = notificationStrategies;
    }

    public Notification getNotificationStrategy(String notificationType) {
        return notificationStrategies.get(notificationType);
    }

}
