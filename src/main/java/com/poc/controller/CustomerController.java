package com.poc.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.component.CustomerComponent;
import com.poc.model.Customer;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/customer")
public class CustomerController
{
    private CustomerComponent customerComponent;

    public CustomerController(CustomerComponent customerRepository)
    {
        this.customerComponent = customerRepository;
    }

    @PostMapping
    public Mono<Customer> save(@RequestBody Customer customer)
    {
        return customerComponent.save(customer);
    }
}
