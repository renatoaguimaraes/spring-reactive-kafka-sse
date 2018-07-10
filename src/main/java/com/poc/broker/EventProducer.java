package com.poc.broker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.model.Customer;

@Component
public class EventProducer
{
    private static final Logger LOG = LoggerFactory.getLogger(EventProducer.class);

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper mapper = new ObjectMapper();

    public EventProducer(KafkaTemplate<String, String> kafkaTemplate)
    {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Customer customer)
    {
        try
        {
            String json = mapper.writeValueAsString(customer);

            kafkaTemplate.send("test", json);
        }
        catch (JsonProcessingException e)
        {
            LOG.error("Object to json converter error.", e);
        }
    }
}
