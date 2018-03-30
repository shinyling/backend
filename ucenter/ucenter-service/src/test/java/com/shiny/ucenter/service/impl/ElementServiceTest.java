package com.shiny.ucenter.service.impl;

import com.alibaba.fastjson.JSON;
import com.shiny.ucenter.common.dto.Result;
import com.shiny.ucenter.common.entity.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ElementServiceTest {

    @Autowired
    private ElementService elementService;

    @Test
    public void findElementsByRoleId() throws Exception {
    }

    @Test
    public void findAllElements() throws Exception {
        Result Result=elementService.findAllElements();
        System.out.println(JSON.toJSONString(Result));
    }

    @Test
    public void addElement() throws Exception {
        Element element=new Element();
        element.setId(UUID.randomUUID().toString());
        element.setCode("100000");
        element.setDescription("主页");
        elementService.addElement(element);
    }

}