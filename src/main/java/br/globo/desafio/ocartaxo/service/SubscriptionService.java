package br.globo.desafio.ocartaxo.service;


import br.globo.desafio.ocartaxo.dto.EventHistoryDTO;
import br.globo.desafio.ocartaxo.dto.NotificationType;
import br.globo.desafio.ocartaxo.dto.SubscriptionDTO;
import br.globo.desafio.ocartaxo.exception.SubscriptionNotFoundException;
import br.globo.desafio.ocartaxo.logger.ApplicationLogger;
import br.globo.desafio.ocartaxo.mapper.SubscriptionMapper;
import br.globo.desafio.ocartaxo.model.EventHistory;
import br.globo.desafio.ocartaxo.model.Subscription;
import br.globo.desafio.ocartaxo.repository.SubscriptionRepository;
import br.globo.desafio.ocartaxo.subscription.NotifcationFactory;
import br.globo.desafio.ocartaxo.subscription.Notification;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

    private SubscriptionRepository subscriptionRepository;

    private SubscriptionMapper subsMapper = Mappers.getMapper(SubscriptionMapper.class);

    private EventHistoryService eventHistoryService;

    private NotifcationFactory notfications;

    public SubscriptionService(SubscriptionRepository subscriptionRepository, EventHistoryService eventHistoryService, NotifcationFactory notfications) {
        this.subscriptionRepository = subscriptionRepository;
        this.eventHistoryService = eventHistoryService;
        this.notfications = notfications;
    }

    public SubscriptionDTO getSubscription(String id) {

        if (!isSavedSubscription(id)) {
            throw new SubscriptionNotFoundException(id);
        }

        Subscription s = subscriptionRepository.findBySubscriptionId(id).get();
        return subsMapper.toDTO(s);
    }


    public EventHistoryDTO notifacteSubscription(String id, NotificationType notificationsType) {

        Notification n = notfications.getNotificationStrategy(notificationsType.toString());

        Subscription subscription = n.subscript(id, subscriptionRepository);
        return createHistoryEvent(subscription, notificationsType);
    }


    private EventHistoryDTO createHistoryEvent(Subscription s, NotificationType eventType) {

        EventHistory eh = new EventHistory(eventType, s);
        EventHistoryDTO newEventHistory = eventHistoryService.registerEvent(eh);

        ApplicationLogger.logInfo("Event history created! Subscription id: " + s.getId());

        return newEventHistory;
    }

    private boolean isSavedSubscription(String id) {
        return subscriptionRepository.findBySubscriptionId(id).isPresent();
    }

}
