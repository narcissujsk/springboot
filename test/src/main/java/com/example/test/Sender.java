package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;

@Component
public class Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Scheduled(fixedDelay = 1000L)
    public void send2() {
        System.out.println();
        System.out.println("*******************send************************");
        String con=""+new Date();
        System.out.println(con);
        System.out.println("*******************send end************************");
        System.out.println();
        this.rabbitTemplate.convertAndSend("foo", con);
    }

}
