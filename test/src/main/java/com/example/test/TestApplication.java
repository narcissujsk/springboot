package com.example.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Date;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.EnableScheduling;

@RabbitListener(queues = "foo")
@EnableScheduling
@SpringBootApplication
public class TestApplication {
    @Bean
    public Sender mySender() {
        return new Sender();
    }

    @Bean
    public Queue fooQueue() {
        return new Queue("foo");
    }

    @RabbitHandler
    public void process(@Payload String foo) {
        System.out.println();
        System.out.println("*******************RabbitHandler************************");
        System.out.println(new Date() + ": " + foo);
        System.out.println("*******************RabbitHandler end************************");
        System.out.println();

    }
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}
