package com.shiny.ucenter.service.impl;

import com.shiny.ucenter.dao.OauthClientDetailsMapper;
import com.shiny.ucenter.entity.OauthClientDetails;
import com.shiny.ucenter.service.OauthClientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author DELL shiny
 * @create 2018/7/10
 */
@Service
public class OauthClientDetailsServiceImpl implements OauthClientDetailsService {

    @Autowired
    private OauthClientDetailsMapper oauthClientDetailsMapper;

    @Override
    public OauthClientDetails queryByPrinciple(OauthClientDetails oauthClientDetails) {
        return oauthClientDetailsMapper.selectByPrinciple(oauthClientDetails);
    }
}
