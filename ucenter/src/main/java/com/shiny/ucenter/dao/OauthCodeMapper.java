package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.OauthCode;

public interface OauthCodeMapper {
    int insert(OauthCode record);

    int insertSelective(OauthCode record);
}