package com.shiny.ucenter.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shiny.ucenter.api.ResourceApi;
import com.shiny.ucenter.common.dto.Result;
import com.shiny.ucenter.common.entity.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shiny
 **/
@RestController
@RequestMapping("resource")
public class ResourceController {

    @Reference(version = "1.0.0")
    private ResourceApi resourceApi;

    @PostMapping("add")
    public Result addResource(Resource resource){
        return resourceApi.addResource(resource);
    }
}
