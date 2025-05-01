package com.rabbitMq.poc.controller;

import com.rabbitMq.poc.CO.UserCO;
import com.rabbitMq.poc.service.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/rabbitmq")
@RequiredArgsConstructor
public class RabbitMQController {

    private final RabbitMQProducer rabbitMQProducer;

//    @GetMapping("/produce/{message}")
//    public ResponseEntity<String> produce(@PathVariable String message) {
//        rabbitMQProducer.sendMessage(message);
//        return ResponseEntity.ok("Message received successfully!");
//    }

    @PostMapping("/produce/body")
    public ResponseEntity<String> produceBody(@RequestBody  UserCO userCO) {
        rabbitMQProducer.sendMessageBody(userCO);
        return ResponseEntity.ok("Message body received successfully!");
    }
}
