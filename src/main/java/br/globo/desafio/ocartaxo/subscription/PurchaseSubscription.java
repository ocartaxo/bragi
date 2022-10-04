package br.globo.desafio.ocartaxo.subscription;

import br.globo.desafio.ocartaxo.model.Status;
import br.globo.desafio.ocartaxo.exception.SubscriptionAlreadyExistException;
import br.globo.desafio.ocartaxo.model.Subscription;
import br.globo.desafio.ocartaxo.repository.SubscriptionRepository;
import org.springframework.stereotype.Component;

@Component
public class PurchaseSubscription extends SubscriptionValidation implements Notification {

    @Override
    public Subscription subscript(String subscriptionId, SubscriptionRepository repository) {


        if (exists(subscriptionId, repository)){
            throw new SubscriptionAlreadyExistException(subscriptionId);
        }

        Subscription subscription = new Subscription(Status.ACTIVE);

        // checks wheter needs to save status before
        repository.save(subscription);

        return subscription;
    }
}
