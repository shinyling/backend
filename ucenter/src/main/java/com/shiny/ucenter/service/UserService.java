package com.shiny.ucenter.service;

import com.shiny.ucenter.dto.JSONResult;
import com.shiny.ucenter.entity.User;
import com.shiny.ucenter.exception.BusinessException;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * @author DELL shiny
 * @create 2018/7/5
 */
public interface UserService {

    User queryByPrincipal(User user);

    boolean register(User user) throws BusinessException, InvalidKeySpecException, NoSuchAlgorithmException;

    JSONResult login(User user) throws InvalidKeySpecException, NoSuchAlgorithmException;
}
