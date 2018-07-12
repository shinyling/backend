package com.shiny.ucenter.service.impl;

import com.shiny.ucenter.config.cache.IdGenerator;
import com.shiny.ucenter.dao.UserMapper;
import com.shiny.ucenter.entity.User;
import com.shiny.ucenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author DELL shiny
 * @create 2018/7/5
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IdGenerator idGenerator;

    @Override
    public void add(User currentUser,User user) {
        user.setId(String.valueOf(idGenerator.next("user", Long.parseLong(currentUser.getId()))));
        user.setCreateBy(currentUser.getId());
        user.setCreateTime(new Date());
        user.setIsDelete(false);
        user.setIsLocked(false);
        user.setStatus(true);
        userMapper.insert(user);
    }

    @Override
    public User queryByPrincipal(User user) {
        return userMapper.selectByPrincipal(user);
    }
}
