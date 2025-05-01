package com.rabbitMq.poc.service;

import com.rabbitMq.poc.CO.UserCO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RabbitMQProducer {

    private final RabbitTemplate rabbitTemplate;

//    public void sendMessage(String message) {
//        log.info("Sending message: {}", message);
//        rabbitTemplate.convertAndSend("topicExchange", "tempRoutingKey", message);
//    }
//
//    public void sendMessage(String message) {
//        log.info("Sending message: {}", message);
//        rabbitTemplate.convertAndSend("fanoutExchange", "", message);
//    }

    public void sendMessageBody(UserCO userCO) {
        log.info("Sending body: {}", userCO.toString());
        rabbitTemplate.convertAndSend("fanoutExchange", "", userCO);
    }
}
