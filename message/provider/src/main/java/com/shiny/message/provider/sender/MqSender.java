package com.shiny.message.provider.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author shiny
 **/
@Component
public class MqSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(){
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        System.out.println("sender :  hello mq ");
        rabbitTemplate.convertAndSend("mq.ex","mqkey","hello mq",correlationData);
    }
}
