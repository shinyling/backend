package com.shiny.ucenter.controller;

import com.shiny.ucenter.dto.JSONResult;
import com.shiny.ucenter.dto.MenuDto;
import com.shiny.ucenter.dto.ResultCode;
import com.shiny.ucenter.entity.User;
import com.shiny.ucenter.exception.BusinessException;
import com.shiny.ucenter.service.MenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author DELL shiny
 * @create 2018/7/18
 */
@RestController
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("loadMenuByUserId")
    public JSONResult loadMenuByUserId(@RequestBody User user){
        if(user==null){
            return new JSONResult(ResultCode.FAILURE,"参数错误");
        }
        String userId=user.getId();
        if(StringUtils.isEmpty(userId)){
            return new JSONResult(ResultCode.FAILURE,"参数错误");
        }
        List<MenuDto> menuDtoList=menuService.selectMenuByUserId(userId);
        return new JSONResult(menuDtoList);
    }

    @RequestMapping("add")
    public JSONResult add(@RequestBody MenuDto menuDto) throws BusinessException {
        if(menuDto==null){
            return new JSONResult(ResultCode.FAILURE,"参数错误");
        }
        boolean flag=menuService.addMenu(menuDto);
        if(flag){
            return new JSONResult(ResultCode.FAILURE,"系统错误");
        }
        return new JSONResult();
    }
}
