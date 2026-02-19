package br.com.fiap.oficina.customer.messaging.event;

public record CustomerCreatedEvent(
        Long customerId,
        String name,
        String email
) {
}
