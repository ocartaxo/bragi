package br.globo.desafio.ocartaxo.exception;

import br.globo.desafio.ocartaxo.logger.ApplicationLogger;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.support.ListenerExecutionFailedException;
import org.springframework.util.ErrorHandler;


public class RabbitmqErrorHandler implements ErrorHandler {

    @Override
    public void handleError(Throwable t) {

        ListenerExecutionFailedException failedExecution = ((ListenerExecutionFailedException) t);

        String queueName = failedExecution
                        .getFailedMessage()
                        .getMessageProperties()
                        .getConsumerQueue();

        String msg = new String(failedExecution.getFailedMessage().getBody());


        String cause = t.getCause().getCause().getMessage();

        ApplicationLogger.logError(queueName, msg, cause);

        throw new AmqpRejectAndDontRequeueException("Shouldn't return this message to queue");
    }
}
