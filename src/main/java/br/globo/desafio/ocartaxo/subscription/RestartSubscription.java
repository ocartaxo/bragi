package br.globo.desafio.ocartaxo.subscription;

import br.globo.desafio.ocartaxo.exception.SubscriptionNotFoundException;
import br.globo.desafio.ocartaxo.model.Status;
import br.globo.desafio.ocartaxo.model.Subscription;
import br.globo.desafio.ocartaxo.repository.SubscriptionRepository;
import org.springframework.stereotype.Component;

@Component
public class RestartSubscription extends SubscriptionValidation implements Notification {

    @Override
    public Subscription subscript(String subscriptionId, SubscriptionRepository repository) {

        if(!exists(subscriptionId, repository)) {
            throw new SubscriptionNotFoundException(subscriptionId);
        }


        Subscription subscription = repository.findBySubscriptionId(subscriptionId).get();
        subscription.setStatus(Status.ACTIVE);

        return subscription;
    }
}
