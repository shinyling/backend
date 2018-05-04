package com.shiny.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author shiny
 **/
@Service
public class UserApi {

    @Autowired
    RestTemplate restTemplate;

    public String invokeProvider(){
        return restTemplate.getForObject("http://U-SERVICE/info",String.class);
    }
}
