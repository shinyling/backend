package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.UserGroupRoleKey;

public interface UserGroupRoleMapper {
    int deleteByPrimaryKey(UserGroupRoleKey key);

    int insert(UserGroupRoleKey record);

    int insertSelective(UserGroupRoleKey record);
}