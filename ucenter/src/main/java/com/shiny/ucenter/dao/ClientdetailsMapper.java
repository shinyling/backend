package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.Clientdetails;

public interface ClientdetailsMapper {
    int deleteByPrimaryKey(String appid);

    int insert(Clientdetails record);

    int insertSelective(Clientdetails record);

    Clientdetails selectByPrimaryKey(String appid);

    int updateByPrimaryKeySelective(Clientdetails record);

    int updateByPrimaryKey(Clientdetails record);
}