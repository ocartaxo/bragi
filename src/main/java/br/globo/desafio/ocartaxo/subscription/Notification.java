package br.globo.desafio.ocartaxo.subscription;

import br.globo.desafio.ocartaxo.dto.NotificationType;
import br.globo.desafio.ocartaxo.model.Subscription;
import br.globo.desafio.ocartaxo.repository.SubscriptionRepository;

public interface Notification {
    public Subscription subscript(String subscriptionId, SubscriptionRepository repository);
}
