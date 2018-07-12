package com.shiny.ucenter.service.impl;

import com.shiny.ucenter.dao.UserMapper;
import com.shiny.ucenter.entity.User;
import com.shiny.ucenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DELL shiny
 * @create 2018/7/5
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public void add(User user) {
        userMapper.insert(user);
    }

    @Override
    public User queryByPrincipal(User user) {
        return userMapper.selectByPrincipal(user);
    }
}
