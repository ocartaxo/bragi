package br.globo.desafio.ocartaxo.connection;


import br.globo.desafio.ocartaxo.constant.RabbitmqConstant;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RabbitMQConnection {

    private static final String NOME_EXCHANGE = "amq.direct";
    private AmqpAdmin amqpAdmin;


    public RabbitMQConnection(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    private Queue createQueue(String nomeFila) {
        return new Queue(nomeFila, true, false, false);
    }

    private DirectExchange createDirectExchange() {
        return new DirectExchange(NOME_EXCHANGE);
    }

    private Binding createBinding(Queue q, DirectExchange de) {
        return new Binding(q.getName(), Binding.DestinationType.QUEUE, de.getName(), q.getName(), null);
    }

    @PostConstruct
    private void initialConfig() {
        Queue listner = this.createQueue(RabbitmqConstant.SUBSCRIPTIONS);
        DirectExchange de = this.createDirectExchange();
        Binding b = this.createBinding(listner, de);


        // Criando as filas no RabbitMQ
        this.amqpAdmin.declareQueue(listner);
        this.amqpAdmin.declareExchange(de);
        this.amqpAdmin.declareBinding(b);
    }
}
