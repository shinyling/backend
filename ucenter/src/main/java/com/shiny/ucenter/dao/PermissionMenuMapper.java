package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.PermissionMenu;

public interface PermissionMenuMapper {
    int deleteByPrimaryKey(String permissionId);

    int insert(PermissionMenu record);

    int insertSelective(PermissionMenu record);

    PermissionMenu selectByPrimaryKey(String permissionId);

    int updateByPrimaryKeySelective(PermissionMenu record);

    int updateByPrimaryKey(PermissionMenu record);
}