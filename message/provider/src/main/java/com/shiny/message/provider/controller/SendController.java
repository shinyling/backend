package com.shiny.message.provider.controller;

import com.shiny.message.provider.sender.MqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shiny
 **/
@RestController
public class SendController {

    @Autowired
    private MqSender mqSender;

    @RequestMapping("send")
    public void send(){
        mqSender.send();
    }
}
