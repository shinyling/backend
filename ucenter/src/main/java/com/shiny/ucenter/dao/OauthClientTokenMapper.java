package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.OauthClientToken;

public interface OauthClientTokenMapper {
    int deleteByPrimaryKey(String authenticationId);

    int insert(OauthClientToken record);

    int insertSelective(OauthClientToken record);

    OauthClientToken selectByPrimaryKey(String authenticationId);

    int updateByPrimaryKeySelective(OauthClientToken record);

    int updateByPrimaryKeyWithBLOBs(OauthClientToken record);

    int updateByPrimaryKey(OauthClientToken record);
}