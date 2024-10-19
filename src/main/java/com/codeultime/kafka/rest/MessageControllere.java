package com.codeultime.kafka.rest;

import com.codeultime.kafka.common.KafkaTopic;
import com.codeultime.kafka.producer.ProducerService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/event")
public class MessageControllere {
    private final ProducerService producerService;


    public MessageControllere(ProducerService producerService) {
        this.producerService = producerService;
    }

    public void sendMessage(@RequestBody String message) {
        producerService.sendMessage(KafkaTopic.KAFKA_FORMATION.getValue(), message);
    }
}
