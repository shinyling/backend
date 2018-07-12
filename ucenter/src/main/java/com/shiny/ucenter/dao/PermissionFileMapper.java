package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.PermissionFileKey;

public interface PermissionFileMapper {
    int deleteByPrimaryKey(PermissionFileKey key);

    int insert(PermissionFileKey record);

    int insertSelective(PermissionFileKey record);
}