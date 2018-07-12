package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.UserGroup;

public interface UserGroupMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserGroup record);

    int insertSelective(UserGroup record);

    UserGroup selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserGroup record);

    int updateByPrimaryKey(UserGroup record);
}