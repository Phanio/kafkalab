package com.codeultime.kafka.consumer;

import com.codeultime.kafka.common.KafkaGroupID;
import com.codeultime.kafka.common.KafkaTopic;
import jakarta.annotation.PostConstruct;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

@Service
public class ConsumerService {

    /*
    @KafkaListener(topics = "TOPIC_EVENT", groupId = "GROUP_EVENT")
    public void listen(String message){
        System.out.println("Received Message: " + message);
    }
    */

    protected Properties properties;
    private KafkaConsumer<String, String> consumer;

    @Bean
    public void setUp() {
        properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, KafkaGroupID.GROUP_EVENT.name());
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(List.of(KafkaTopic.KAFKA_FORMATION.getValue()));
    }

    @Scheduled(fixedRate = 1000)
    public void process() {
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
        records.forEach(record -> System.out.println(record.value()));
    }

}
