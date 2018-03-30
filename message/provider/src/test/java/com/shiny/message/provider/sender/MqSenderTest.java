package com.shiny.message.provider.sender;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MqSenderTest {

    @Autowired
    private MqSender mqSender;

    @org.junit.Test
    public void send() throws Exception {
        mqSender.send();
    }

}