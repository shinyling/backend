package com.shiny.ucenter.controller;

import com.shiny.ucenter.dto.BkResCode;
import com.shiny.ucenter.dto.BkResponse;
import com.shiny.ucenter.entity.User;
import com.shiny.ucenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author DELL shiny
 * @create 2018/7/5
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("login_page")
    public BkResponse login_page(){
        return new BkResponse<>(BkResCode.REQUIRE_LOGIN);
    }

    @RequestMapping("add")
    public BkResponse add(@RequestBody User user){
        userService.add(user);
        return new BkResponse();
    }

    @RequestMapping("list")
    public BkResponse list(){
        List<User> userList=userService.listAll();
        return new BkResponse(userList);
    }

}
