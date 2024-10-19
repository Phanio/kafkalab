package com.codeultime.kafka.rest;


import com.codeultime.kafka.consumer.ConsumerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/message")
public class ConsumerController {

    @GetMapping
    public List<String> getMessage() {
        return ConsumerService.getMessages();
    }
}
