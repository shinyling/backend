package com.shiny.ucenter.service.impl;

import com.shiny.ucenter.common.entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceTest {

    @Autowired
    RoleService roleService;

    @Test
    public void addRole() throws Exception {
        Role role=new Role();
        role.setName("管理员");
        roleService.addRole(role);
    }

    @Test
    public void findRolesByUid() throws Exception {
    }

}