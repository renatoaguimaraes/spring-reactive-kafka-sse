package com.poc.component;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.poc.broker.EventProducer;
import com.poc.model.Customer;

import reactor.core.publisher.Mono;

@Component
public class CustomerComponent
{
    private final EventProducer eventProducer;

    public CustomerComponent(EventProducer eventProducer)
    {
        this.eventProducer = eventProducer;
    }

    public Mono<Customer> save(Customer customer)
    {
        return Mono.just(customer).doOnSuccess(c -> c.setId(UUID.randomUUID().toString())).doOnSuccess(eventProducer::send);
    }
}
