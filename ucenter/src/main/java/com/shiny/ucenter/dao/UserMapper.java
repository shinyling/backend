package com.shiny.ucenter.dao;

import com.shiny.ucenter.dto.UserDto;
import com.shiny.ucenter.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    UserDto selectByMobile(String mobile);
}