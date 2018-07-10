package com.poc.broker;

import java.util.UUID;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

@Component
public class EventConsumer
{
    private final EmitterProcessor<ServerSentEvent<String>> emitter = EmitterProcessor.create();

    public Flux<ServerSentEvent<String>> get()
    {
        return emitter.log();
    }

    @KafkaListener(topics = "${kafka.topic.name}")
    public void receive(String data)
    {
        emitter.onNext(ServerSentEvent.builder(data).id(UUID.randomUUID().toString()).build());
    }
}
