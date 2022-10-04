package br.globo.desafio.ocartaxo.subscription;

import br.globo.desafio.ocartaxo.repository.SubscriptionRepository;

public abstract class SubscriptionValidation {

    public boolean exists(String subscriptionId, SubscriptionRepository repository) {
        return repository.findBySubscriptionId(subscriptionId).isPresent();
    }

}
