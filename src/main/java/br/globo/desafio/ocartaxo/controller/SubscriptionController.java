package br.globo.desafio.ocartaxo.controller;


import br.globo.desafio.ocartaxo.service.RabbitmqService;
import br.globo.desafio.ocartaxo.service.SubscriptionService;
import br.globo.desafio.ocartaxo.constant.RabbitmqConstant;
import br.globo.desafio.ocartaxo.dto.NotificationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/subscription")
public class SubscriptionController {

    private RabbitmqService rabbitmqService;
    private SubscriptionService service;

    public SubscriptionController(RabbitmqService rabbitmqService, SubscriptionService service) {
        this.rabbitmqService = rabbitmqService;
        this.service = service;
    }

    @PostMapping
    private ResponseEntity<HttpStatus> sendNotification(@RequestBody NotificationRequest notification) {
        this.rabbitmqService.sendNotification(RabbitmqConstant.SUBSCRIPTIONS, notification);



        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }

}
