package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.OauthRefreshToken;

public interface OauthRefreshTokenMapper {
    int insert(OauthRefreshToken record);

    int insertSelective(OauthRefreshToken record);
}