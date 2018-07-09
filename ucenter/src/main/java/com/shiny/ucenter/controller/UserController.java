package com.shiny.ucenter.controller;

import com.shiny.ucenter.dto.BkResponse;
import com.shiny.ucenter.entity.User;
import com.shiny.ucenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author DELL shiny
 * @create 2018/7/5
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("add")
    public BkResponse add(@RequestBody User user){
        userService.add(user);
        return new BkResponse();
    }

    @RequestMapping("list")
    public ModelAndView list(){
        List<User> userList=userService.listAll();
        Map<String,List<User>> model=new HashMap();
        model.put("userList",userList);
        return new ModelAndView("index",model);
    }

}
