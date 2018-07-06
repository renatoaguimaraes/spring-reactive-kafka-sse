package com.poc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.QueryLogger;
import com.datastax.driver.core.utils.UUIDs;
import com.poc.model.Customer;
import com.poc.repository.CustomerRepository;

@SpringBootApplication(scanBasePackages = "com.poc")
public class Application implements CommandLineRunner
{

    @Autowired
    private CustomerRepository customerRepo;

    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        customerRepo.saveAll(Arrays.asList(
                new Customer(UUIDs.timeBased(), "Walter", "White", 29),
                new Customer(UUIDs.timeBased(), "Skyler", "White", 24),
                new Customer(UUIDs.timeBased(), "Saul", "Goodman", 27),
                new Customer(UUIDs.timeBased(), "Jesse", "Pinkman", 24)));
    }

    @Bean
    public QueryLogger queryLogger(Cluster cluster)
    {
        QueryLogger queryLogger = QueryLogger.builder().build();
        cluster.register(queryLogger);
        return queryLogger;
    }

}