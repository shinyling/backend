package com.shiny.ucenter.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shiny.ucenter.api.ElementApi;
import com.shiny.ucenter.common.dto.Result;
import com.shiny.ucenter.common.entity.Element;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shiny
 **/
@RestController
@RequestMapping("element")
public class ElementController {

    @Reference(version = "1.0.0")
    private ElementApi elementApi;

    @PostMapping("add")
    public Result addElement(Element element){
        return elementApi.addElement(element);
    }
}
