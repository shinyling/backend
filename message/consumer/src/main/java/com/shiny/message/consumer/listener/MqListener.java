package com.shiny.message.consumer.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;


/**
 * @author shiny
 **/
@Component
public class MqListener {

    @RabbitListener(queues = "mq",containerFactory = "rabbitListenerContainerFactory")
    @RabbitHandler
    public void process(Message message, Channel channel) throws Exception {
        System.out.println("**********************");
        System.out.println("Receiver  : " + new String(message.getBody()));
        System.out.println("**********************");
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
    }

}
