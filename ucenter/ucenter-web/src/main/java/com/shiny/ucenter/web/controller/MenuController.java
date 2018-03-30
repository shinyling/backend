package com.shiny.ucenter.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shiny.ucenter.api.MenuApi;
import com.shiny.ucenter.common.dto.Result;
import com.shiny.ucenter.common.entity.Menu;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shiny
 **/
@RestController
@RequestMapping("menu")
public class MenuController {

    @Reference(version = "1.0.0")
    private MenuApi menuApi;

    @PostMapping("add")
    public Result addMenu(Menu menu){
        return menuApi.addMenu(menu);
    }
}
