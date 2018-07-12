package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.PermissionOperation;

public interface PermissionOperationMapper {
    int deleteByPrimaryKey(String permissionId);

    int insert(PermissionOperation record);

    int insertSelective(PermissionOperation record);

    PermissionOperation selectByPrimaryKey(String permissionId);

    int updateByPrimaryKeySelective(PermissionOperation record);

    int updateByPrimaryKey(PermissionOperation record);
}