package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.Element;

public interface ElementMapper {
    int deleteByPrimaryKey(String id);

    int insert(Element record);

    int insertSelective(Element record);

    Element selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Element record);

    int updateByPrimaryKey(Element record);
}