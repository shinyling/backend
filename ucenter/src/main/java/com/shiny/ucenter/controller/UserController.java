package com.shiny.ucenter.controller;

import com.shiny.ucenter.config.token.AuthIgnore;
import com.shiny.ucenter.config.token.RequestLimit;
import com.shiny.ucenter.dto.JSONResult;
import com.shiny.ucenter.dto.ResultCode;
import com.shiny.ucenter.entity.User;
import com.shiny.ucenter.exception.BusinessException;
import com.shiny.ucenter.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * @author DELL shiny
 * @create 2018/7/5
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestLimit(count = 2)
    @RequestMapping("register")
    @AuthIgnore
    public JSONResult register(@RequestBody User user) throws BusinessException, InvalidKeySpecException, NoSuchAlgorithmException {
        if(user==null){
            return new JSONResult(ResultCode.FAILURE);
        }
        boolean flag=userService.register(user);
        if(flag){
            return new JSONResult();
        }
        return new JSONResult(ResultCode.FAILURE);
    }

    @RequestLimit(count = 2)
    @RequestMapping("login")
    @AuthIgnore
    public JSONResult login(@RequestBody User user) throws InvalidKeySpecException, NoSuchAlgorithmException {
        if(user==null){
            return new JSONResult(ResultCode.FAILURE);
        }
        if(StringUtils.isEmpty(user.getMobile())){
            return new JSONResult(ResultCode.FAILURE,"参数错误!");
        }
        if(StringUtils.isEmpty(user.getPassword())){
            return new JSONResult(ResultCode.FAILURE,"参数错误!");
        }
        JSONResult jsonResult=userService.login(user);
        return jsonResult;
    }

}
