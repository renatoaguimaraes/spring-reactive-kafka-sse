package com.poc.component;

import java.util.UUID;
import java.util.function.Consumer;

import org.springframework.stereotype.Component;

import com.datastax.driver.core.utils.UUIDs;
import com.poc.broker.EventProducer;
import com.poc.model.Customer;
import com.poc.repository.CustomerRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CustomerComponent
{
    private final CustomerRepository customerRepository;
    private final EventProducer eventProducer;

    public CustomerComponent(CustomerRepository customerRepository, EventProducer eventProducer)
    {
        this.customerRepository = customerRepository;
        this.eventProducer = eventProducer;
    }

    public Mono<Customer> getCustomerById(UUID id)
    {
        return customerRepository.findById(id);
    }

    public Flux<Customer> findByFirstNameAndLastName(String firstName, String lastName)
    {
        return customerRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public Mono<Customer> save(Customer customer)
    {
        Consumer<Customer> setId = c -> c.setId(UUIDs.timeBased());

        Consumer<Customer> save = customerRepository::save;

        Consumer<Customer> send = eventProducer::send;

        return Mono.just(customer).doOnSuccess(setId).doOnSuccess(save).doOnSuccess(send);
    }
}
