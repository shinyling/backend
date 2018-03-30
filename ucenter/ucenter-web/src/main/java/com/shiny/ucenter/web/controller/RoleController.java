package com.shiny.ucenter.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shiny.ucenter.api.RoleApi;
import com.shiny.ucenter.common.dto.Result;
import com.shiny.ucenter.common.entity.Role;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shiny
 **/
@RestController
@RequestMapping("role")
public class RoleController {

    @Reference(version = "1.0.0")
    private RoleApi roleApi;

    @RequestMapping("add")
    public Result addRole(Role role){
        return roleApi.addRole(role);
    }

    @PostMapping("bindElement")
    public Result bindElement(String role_id,String element_id){
        return roleApi.bindElements(role_id,element_id);
    }

    @PostMapping("bindFile")
    public Result bindFile(String role_id,String file_id){
        return roleApi.bindFiles(role_id,file_id);
    }

    @PostMapping("bindMenu")
    public Result bindMenu(String role_id,String menu_id){
        return roleApi.bindMenus(role_id,menu_id);
    }

    @PostMapping("bindOperation")
    public Result bindOperation(String role_id,String operation_id){
        return roleApi.bindOperations(role_id,operation_id);
    }

    @PostMapping("bindResource")
    public Result bindResource(String role_id,String resource_id){
        return roleApi.bindResources(role_id,resource_id);
    }
}
