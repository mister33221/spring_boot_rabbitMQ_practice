package com.example.rabbitMQ.config.rabbitMQ;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// @EnableRabbit is used to enable the RabbitMQ listener
@EnableRabbit
public class RabbitMQConfig {

    // MessageConverter is used to convert the message to JSON format
    @Bean
    public MessageConverter jsonMessageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    // Queue is used to create a queue
    @Bean
    public Queue tpuQueue() {
        return new Queue("myQueue", true);
    }

}
