package br.globo.desafio.ocartaxo.exception;

public class SubscriptionNotFoundException extends RuntimeException{

    public SubscriptionNotFoundException(String id) {
        super("Subscription with id [" + id + "] does not exists");
    }
}
