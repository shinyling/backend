package com.shiny.ucenter.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.shiny.ucenter.api.MenuApi;
import com.shiny.ucenter.common.dto.Result;
import com.shiny.ucenter.common.entity.Menu;
import com.shiny.ucenter.common.entity.MenuExample;
import com.shiny.ucenter.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

/**
 * @author shiny
 **/
@Service(version = "1.0.0")
public class MenuService implements MenuApi {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Result addMenu(Menu menu) {
        MenuExample menuExample=new MenuExample();
        menuExample.createCriteria().andNameEqualTo(menu.getName());
        List<Menu> menuList=menuMapper.selectByExample(menuExample);
        if(menuList!=null&&menuList.size()>0){
            return new Result("此菜单已存在!");
        }
        menu.setId(UUID.randomUUID().toString());
        return new Result(menuMapper.insert(menu));
    }
}
