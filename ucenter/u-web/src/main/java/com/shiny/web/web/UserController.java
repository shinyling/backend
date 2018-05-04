package com.shiny.web.web;

import com.shiny.web.api.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shiny
 **/
@RestController
public class UserController {

    @Autowired
    UserApi userApi;

    @RequestMapping("info")
    public String info(){
        return userApi.invokeProvider();
    }
}
