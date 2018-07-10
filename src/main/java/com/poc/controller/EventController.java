package com.poc.controller;

import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.broker.EventConsumer;

import reactor.core.publisher.Flux;

@RestController
public class EventController
{
    private EventConsumer eventConsumer;

    public EventController(EventConsumer eventConsumer)
    {
        this.eventConsumer = eventConsumer;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(name = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<String>> getEvents()
    {
        return eventConsumer.get();
    }

}
