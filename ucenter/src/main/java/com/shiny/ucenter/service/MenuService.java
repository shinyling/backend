package com.shiny.ucenter.service;

import com.shiny.ucenter.dto.MenuDto;
import com.shiny.ucenter.exception.BusinessException;

import java.util.List;

/**
 * Created by DELL on 2018/7/18.
 */
public interface MenuService{

    List<MenuDto> selectMenuByUserId(String userId);

    boolean addMenu(MenuDto menuDto) throws BusinessException;
}
