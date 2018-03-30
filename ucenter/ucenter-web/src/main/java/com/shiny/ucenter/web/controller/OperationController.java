package com.shiny.ucenter.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shiny.ucenter.api.OperationApi;
import com.shiny.ucenter.common.dto.Result;
import com.shiny.ucenter.common.entity.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shiny
 **/
@RestController
@RequestMapping("operation")
public class OperationController {

    @Reference(version = "1.0.0")
    private OperationApi operationApi;

    @PostMapping("add")
    public Result addOperation(Operation operation){
        return operationApi.addOperation(operation);
    }
}
