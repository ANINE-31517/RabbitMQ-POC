package com.rabbitMq.poc.service;

import com.rabbitMq.poc.CO.UserCO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQConsumer {

//    @RabbitListener(queues = {"tempQueue1", "tempQueue2", "tempQueue3"})
//    public void consume(String message, Message amqpMessage) throws InterruptedException {
//        Thread.sleep(3000);
//
//        String queueName = amqpMessage.getMessageProperties().getConsumerQueue();
//        log.info("Message consumed from {}: {}", queueName, message);
//    }

    @RabbitListener(queues = {"tempQueue1", "tempQueue2", "tempQueue3"})
    public void consume(UserCO userCO, Message amqpMessage) throws InterruptedException {
        Thread.sleep(3000);

        String queueName = amqpMessage.getMessageProperties().getConsumerQueue();
        log.info("Message body consumed from {}: {}", queueName, userCO);
    }
}
