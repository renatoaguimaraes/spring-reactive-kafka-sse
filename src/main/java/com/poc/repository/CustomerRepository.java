package com.poc.repository;

import java.util.UUID;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.poc.model.Customer;

import reactor.core.publisher.Flux;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, UUID>
{
    Flux<Customer> findByFirstNameAndLastName(String firstName, String lastName);
}