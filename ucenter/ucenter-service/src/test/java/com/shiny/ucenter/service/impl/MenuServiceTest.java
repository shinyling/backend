package com.shiny.ucenter.service.impl;

import com.shiny.ucenter.common.entity.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuServiceTest {

    @Autowired
    private MenuService menuService;

    @Test
    public void addMenu() throws Exception {
        Menu menu=new Menu();
        menu.setName("系统管理");
        menuService.addMenu(menu);
    }

}