package com.shiny.service.web;

import com.alibaba.fastjson.JSON;
import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shiny
 **/
@Log4j2
@RestController
public class UserController {

    @Autowired
    private EurekaClient eurekaClient;

    @RequestMapping("info")
    public String getInfo(){
        ApplicationInfoManager instance = eurekaClient.getApplicationInfoManager();
        InstanceInfo info=instance.getInfo();
        log.info(" info:{}",info.getHostName());
        return JSON.toJSONString(info);
    }
}
