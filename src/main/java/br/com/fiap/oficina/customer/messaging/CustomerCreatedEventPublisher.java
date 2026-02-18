package br.com.fiap.oficina.customer.messaging;

import br.com.fiap.oficina.customer.messaging.event.CustomerCreatedEvent;

public interface CustomerCreatedEventPublisher {

    void publish(CustomerCreatedEvent event);
}
