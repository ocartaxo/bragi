package br.globo.desafio.ocartaxo.listener;

import br.globo.desafio.ocartaxo.dto.NotificationRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import br.globo.desafio.ocartaxo.constant.RabbitmqConstant;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationsListener {

    @RabbitListener(queues = RabbitmqConstant.SUBSCRIPTIONS, containerFactory = "rabbitListenerContainerFactory")
    public void getMessage(NotificationRequest notification) throws JsonProcessingException, InterruptedException {

        System.out.println(notification.getNotificationType());
        System.out.println(notification.getSubscription());
        System.out.println("************************************************");

    }
}
