package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.OauthClientDetails;

public interface OauthClientDetailsMapper {
    int deleteByPrimaryKey(String clientId);

    int insert(OauthClientDetails record);

    int insertSelective(OauthClientDetails record);

    OauthClientDetails selectByPrimaryKey(String clientId);

    int updateByPrimaryKeySelective(OauthClientDetails record);

    int updateByPrimaryKey(OauthClientDetails record);

    OauthClientDetails queryPrinciple(OauthClientDetails oauthClientDetails);
}