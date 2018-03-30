package com.shiny.message.provider.config;

import com.alibaba.fastjson.JSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shiny
 **/
@Configuration
public class RabbitConfig {

    private Logger logger= LogManager.getLogger(RabbitConfig.class);

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(new Jackson2JsonMessageConverter());
        template.setEncoding("UTF-8");
        template.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                String correlationId = message.getMessageProperties().getCorrelationIdString();
                logger.debug("消息:{} 发送失败,应答码: {} 原因:{} 交换机:{} 路由器:{}", correlationId, replyCode, replyText, exchange, routingKey);
            }
        });
        template.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                if (ack) {
                    logger.debug("消息发送到exchange成功,:{}", JSON.toJSONString(correlationData));
                } else {
                    logger.debug("消息发送到exchange失败，原因:{}", cause);
                }
            }
        });
        return template;
    }

}
