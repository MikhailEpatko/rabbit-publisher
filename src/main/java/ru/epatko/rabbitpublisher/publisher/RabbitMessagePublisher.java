package ru.epatko.rabbitpublisher.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMessagePublisher {

    @Value("${spring.rabbitmq.queueName}")
    private String queueName;
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMessagePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Object object) {
        rabbitTemplate.convertAndSend(queueName, object);
    }
}
