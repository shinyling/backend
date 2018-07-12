package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.PermissionElementKey;

public interface PermissionElementMapper {
    int deleteByPrimaryKey(PermissionElementKey key);

    int insert(PermissionElementKey record);

    int insertSelective(PermissionElementKey record);
}