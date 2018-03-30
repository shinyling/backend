package com.shiny.ucenter.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.shiny.cache.util.RedisUtil;
import com.shiny.ucenter.api.ElementApi;
import com.shiny.ucenter.api.UserApi;
import com.shiny.ucenter.common.dto.Result;
import com.shiny.ucenter.common.dto.UserDto;
import com.shiny.ucenter.common.entity.User;
import com.shiny.ucenter.common.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

/**
 * @author shiny
 **/
@RestController
@RequestMapping("user")
@Validated
public class UserController {

    @Value("${tokenPrefix}")
    private String tokenPrefix;

    @Value("${tokenExpireTime}")
    private long tokenExpireTime;

    @Autowired
    private RedisUtil redisUtil;

    @Reference(version = "1.0.0")
    private UserApi userApi;

    @Reference(version = "1.0.0")
    private ElementApi elementApi;

    @RequestMapping("login")
    public Result login(@RequestBody User user){
        Result result=userApi.login(user.getMobile());
        if(result.isSuccess()){
            User user2= (User) result.getData();
            if(user2!=null){
                UserDto userDto=new UserDto();
                String token=TokenUtil.generateToken(user2.getId());
                redisUtil.set(tokenPrefix+token,user2,tokenExpireTime);
                userDto.setToken(token);
                result.setData(userDto);
                return result;
            }
        }
        return result;
    }

    @RequestMapping("register")
    public Result register(@RequestBody User user){
        return userApi.register(user);
    }

    @RequestMapping("listElement")
    public Result listElement(HttpServletRequest request){
        User user= (User) request.getAttribute("account");
        return userApi.listElementByUid(user.getId());
    }

    @PostMapping("bindRoles")
    public Result bindRoles(@NotNull String userId,@NotNull String roles){
        return userApi.bindRoles(userId,roles);
    }
}
