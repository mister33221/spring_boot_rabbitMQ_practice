package com.example.rabbitMQ.controller;

import com.example.rabbitMQ.model.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {

    private RabbitTemplate rabbitTemplate;

    public SendMessageController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
      // how to send a message to a queue
        rabbitTemplate.convertAndSend("myQueue", message);
        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }

    @GetMapping("/put_message")
    public String putMessage(@RequestParam(name="name") String name, @RequestParam(name="age") Integer age) {
        rabbitTemplate.convertAndSend("tpu.queue", new User(name,age));
        return "this is quick demo for Spring Boot!";
    }

}
