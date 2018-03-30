package com.shiny.ucenter.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.shiny.ucenter.api.UserApi;
import com.shiny.ucenter.common.dto.Result;
import com.shiny.ucenter.common.entity.*;
import com.shiny.ucenter.dao.UserDao;
import com.shiny.ucenter.mapper.UserRoleMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author shiny
 **/
@Component
@Service(version = "1.0.0")
public class UserService implements UserApi{

    private static final Logger logger= LogManager.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public Result<User> login(String mobile) {
        return new Result(userDao.selectByMobile(mobile));
    }

    @Override
    public Result register(User user) {
        User check=userDao.selectByMobile(user.getMobile());
        if(check==null){
            return new Result(userDao.insert(user));
        }else {
            return new Result("手机号已存在");
        }
    }

    @Override
    public Result bindRoles(String userId, String roles) {
        String[] roleArray=roles.split(",");
        for(String roleId:roleArray){
            UserRoleKey userRoleKey=new UserRoleKey();
            userRoleKey.setUserId(userId);
            userRoleKey.setRoleId(roleId);
            userRoleMapper.insert(userRoleKey);
        }
        return new Result();
    }

    @Override
    public Result listElementByUid(String userId) {
        List<Element> elements=userDao.selectElementByUid(userId);
        return new Result(elements);
    }

    @Override
    public Result listFileByUid(String userId) {
        List<File> files=userDao.selectFileByUid(userId);
        return new Result(files);
    }

    @Override
    public Result listMenuByUid(String userId) {
        List<Menu> menus=userDao.selectMenuByUid(userId);
        return new Result(menus);
    }

    @Override
    public Result listOperationByUid(String userId) {
        List<Operation> operations=userDao.selectOperationByUid(userId);
        return new Result(operations);
    }

    @Override
    public Result listResourceByUid(String userId) {
        List<Resource> resources=userDao.selectResourceByUid(userId);
        return new Result(resources);
    }
}
