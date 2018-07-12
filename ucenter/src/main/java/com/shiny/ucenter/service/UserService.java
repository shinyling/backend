package com.shiny.ucenter.service;

import com.shiny.ucenter.entity.User;

import java.util.List;

/**
 * @author DELL shiny
 * @create 2018/7/5
 */
public interface UserService {

    void add(User currentUser,User user);

    User queryByPrincipal(User user);
}
