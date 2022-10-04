package br.globo.desafio.ocartaxo.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendNotification(String nomeFila, Object msg) {
        this.rabbitTemplate.convertAndSend(nomeFila, msg);
    }

}
