package com.shiny.ucenter.service;

import com.shiny.ucenter.entity.OauthClientDetails;

/**
 * Created by DELL on 2018/7/10.
 */
public interface OauthClientDetailsService {

    OauthClientDetails queryByPrinciple(OauthClientDetails oauthClientDetails);
}
