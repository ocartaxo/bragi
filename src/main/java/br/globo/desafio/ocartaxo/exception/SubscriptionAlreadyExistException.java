package br.globo.desafio.ocartaxo.exception;

public class SubscriptionAlreadyExistException extends RuntimeException {
    public SubscriptionAlreadyExistException(String s) {
        super("Subscription " + s + " already purchased");
    }
}
