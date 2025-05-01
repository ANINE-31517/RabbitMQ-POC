package com.rabbitMq.poc.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue queue1() {
        return new Queue("tempQueue1");
    }

    @Bean
    public Queue queue2() {
        return new Queue("tempQueue2");
    }

    @Bean
    public Queue queue3() {
        return new Queue("tempQueue3");
    }

//    @Bean
//    public TopicExchange exchange() {
//        return new TopicExchange("topicExchange");
//    }

    @Bean
    public FanoutExchange exchange() {
        return new FanoutExchange("fanoutExchange");
    }


//    @Bean
//    public Binding binding() {
//        return BindingBuilder.bind(queue())
//                .to(exchange())
//                .with("tempRoutingKey");
//    }

    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(queue1())
                .to(exchange());
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(queue2())
                .to(exchange());
    }

    @Bean
    public Binding binding3() {
        return BindingBuilder.bind(queue3())
                .to(exchange());
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
