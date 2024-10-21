package com.codeultime.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ConsumerService {

    private static List<String> messages = new ArrayList<>();

    @KafkaListener(topics = "kafka-formation")
    public void listen(String message){
        messages.add(message);
    }

    public static List<String> getMessages() {
        return messages;
    }
}
