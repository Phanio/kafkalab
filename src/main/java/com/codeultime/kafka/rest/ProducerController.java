package com.codeultime.kafka.rest;

import com.codeultime.kafka.model.RequestProducer;
import com.codeultime.kafka.producer.ProducerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/producer")
public class ProducerController {
    private final ProducerService producerService;


    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping
    public ResponseEntity sendMessage(@RequestBody RequestProducer producer) {
        try {
            producerService.sendMessage(producer.topic(), producer.message());
            return ResponseEntity.ok().build();
        }catch (RuntimeException ex){
            ex.printStackTrace();
            return new ResponseEntity(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
