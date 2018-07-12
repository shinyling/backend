package com.shiny.ucenter.controller;

import com.alibaba.fastjson.JSON;
import com.shiny.ucenter.config.token.CurrentUser;
import com.shiny.ucenter.dto.JSONResult;
import com.shiny.ucenter.entity.User;
import com.shiny.ucenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DELL shiny
 * @create 2018/7/5
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("add")
    public JSONResult add(@RequestBody User user){
        userService.add(user);
        return new JSONResult();
    }

    @RequestMapping("list")
    public JSONResult list(@CurrentUser User user){
        System.out.println(JSON.toJSONString(user));
        return new JSONResult();
    }

}
