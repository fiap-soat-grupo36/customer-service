package br.com.fiap.oficina.customer.messaging.rabbit;

import br.com.fiap.oficina.customer.messaging.CustomerCreatedEventPublisher;
import br.com.fiap.oficina.customer.messaging.event.CustomerCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class RabbitCustomerCreatedEventPublisher implements CustomerCreatedEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    @Value("${app.messaging.customer-created.exchange}")
    private String exchange;

    @Value("${app.messaging.customer-created.routing-key}")
    private String routingKey;

    @Override
    public void publish(CustomerCreatedEvent event) {
        Map<String, Object> payload = new LinkedHashMap<>();
        payload.put("customerId", event.customerId());
        payload.put("name", event.name());
        payload.put("email", event.email());

        rabbitTemplate.convertAndSend(exchange, routingKey, payload);
        log.info("Evento customer.created publicado para customerId={}", event.customerId());
    }
}
