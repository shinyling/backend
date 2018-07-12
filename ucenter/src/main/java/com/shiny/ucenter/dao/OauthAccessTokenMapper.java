package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.OauthAccessToken;
import com.shiny.ucenter.entity.OauthAccessTokenWithBLOBs;

public interface OauthAccessTokenMapper {
    int deleteByPrimaryKey(String authenticationId);

    int insert(OauthAccessTokenWithBLOBs record);

    int insertSelective(OauthAccessTokenWithBLOBs record);

    OauthAccessTokenWithBLOBs selectByPrimaryKey(String authenticationId);

    int updateByPrimaryKeySelective(OauthAccessTokenWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OauthAccessTokenWithBLOBs record);

    int updateByPrimaryKey(OauthAccessToken record);
}