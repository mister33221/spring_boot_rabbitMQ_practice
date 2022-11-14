package com.example.rabbitMQ.config.rabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveMessageListener {

    /**
     * 監聽 myQueue 隊列
     */
     @RabbitListener(queues = "myQueue")
        public void receiveMessage(String message) {
            System.out.println("Received <" + message + ">");
        }
}
