package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.OauthApprovals;

public interface OauthApprovalsMapper {
    int insert(OauthApprovals record);

    int insertSelective(OauthApprovals record);
}