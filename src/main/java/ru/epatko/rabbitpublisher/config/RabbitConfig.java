package ru.epatko.rabbitpublisher.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {

    @Value("${spring.rabbitmq.queueName}")
    private String queueName;
    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    public TopicExchange getExchange() {
        return new TopicExchange(exchange);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with(queueName);
    }
}
