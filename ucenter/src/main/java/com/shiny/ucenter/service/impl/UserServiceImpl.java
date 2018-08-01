package com.shiny.ucenter.service.impl;

import com.shiny.ucenter.config.cache.IdGenerator;
import com.shiny.ucenter.dao.UserMapper;
import com.shiny.ucenter.dto.JSONResult;
import com.shiny.ucenter.dto.ResultCode;
import com.shiny.ucenter.dto.UserDto;
import com.shiny.ucenter.entity.User;
import com.shiny.ucenter.exception.BusinessException;
import com.shiny.ucenter.service.UserService;
import com.shiny.ucenter.utils.AuthUtils;
import com.shiny.ucenter.utils.PasswordHash;
import com.shiny.ucenter.utils.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public User queryByPrincipal(User user) {
        return userMapper.selectByMobile(user.getMobile());
    }

    @Override
    public boolean register(User user) throws BusinessException, InvalidKeySpecException, NoSuchAlgorithmException {
        String mobile=user.getMobile();
        if(StringUtils.isNotEmpty(mobile)) {
            User storedUser=userMapper.selectByMobile(user.getMobile());
            if(storedUser!=null){
                throw new BusinessException("用户已存在");
            }
        }
        user.setId(String.valueOf(idGenerator.next("user")));
        String password=user.getPassword();
        if(StringUtils.isEmpty(password)){
            throw new BusinessException("密码不能为空");
        }
        String salt=PasswordHash.generateSalt();
        String passwordHash=PasswordHash.createHash(password,salt);
        user.setSalt(salt);
        user.setPassword(passwordHash);
        user.setStatus(true);
        user.setIsLocked(false);
        user.setIsDelete(false);
        userMapper.insert(user);
        return true;
    }

    @Override
    public JSONResult login(User user) throws InvalidKeySpecException, NoSuchAlgorithmException {
        String mobile=user.getMobile();
        UserDto storedUser=userMapper.selectByMobile(mobile);
        String salt=storedUser.getSalt();
        String passwordHash=PasswordHash.createHash(user.getPassword(),salt);
        boolean valid=PasswordHash.validatePassword(user.getPassword(),passwordHash,salt);
        if(valid){
            String accessToken= AuthUtils.generateAccessToken();
            redisUtil.set(accessToken,user,600);
            storedUser.setAccessToken(accessToken);
            return new JSONResult(storedUser);
        } else {
            return new JSONResult(ResultCode.FAILURE,"账号密码错误");
        }
    }
}
