package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.RolePermissionKey;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(RolePermissionKey key);

    int insert(RolePermissionKey record);

    int insertSelective(RolePermissionKey record);
}