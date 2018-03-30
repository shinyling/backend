package com.shiny.ucenter.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.shiny.ucenter.api.RoleApi;
import com.shiny.ucenter.common.dto.Result;
import com.shiny.ucenter.common.entity.*;
import com.shiny.ucenter.dao.UserRoleDao;
import com.shiny.ucenter.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

/**
 * @author shiny
 **/
@Service(version = "1.0.0")
public class RoleService implements RoleApi{

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private RoleElementMapper roleElementMapper;

    @Autowired
    private RoleFileMapper roleFileMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Autowired
    private RoleOperationMapper roleOperationMapper;

    @Autowired
    private RoleResourceMapper roleResourceMapper;

    @Override
    public Result addRole(Role role){
        String name=role.getName();
        RoleExample roleExample=new RoleExample();
        roleExample.createCriteria().andNameEqualTo(name);
        List<Role> roleList=roleMapper.selectByExample(roleExample);
        if(roleList!=null&&roleList.size()>0){
            return new Result("角色名已存在!");
        }else {
            role.setId(UUID.randomUUID().toString());
            roleMapper.insert(role);
            return new Result(role);
        }
    }

    @Override
    public Result findRolesByUid(String userId){
        return new Result(userRoleDao.selectRolesByUid(userId));
    }

    @Override
    public Result bindElements(String roleId, String elementIds) {
        String[] eIds=elementIds.split(",");
        for(String eId:eIds){
            RoleElementKey roleElementKey=new RoleElementKey();
            roleElementKey.setRoleId(roleId);
            roleElementKey.setElementId(eId);
            roleElementMapper.insert(roleElementKey);
        }
        return new Result();
    }

    @Override
    public Result bindFiles(String roleId, String fileIds) {
        String[] fIds=fileIds.split(",");
        for(String fId:fIds){
            RoleFileKey roleFileKey=new RoleFileKey();
            roleFileKey.setFileId(fId);
            roleFileKey.setRoleId(roleId);
            roleFileMapper.insert(roleFileKey);
        }
        return new Result();
    }

    @Override
    public Result bindMenus(String roleId, String menuIds) {
        String[] mIds=menuIds.split(",");
        for(String mId:mIds){
            RoleMenuKey roleMenuKey=new RoleMenuKey();
            roleMenuKey.setMenuId(mId);
            roleMenuKey.setRoleId(roleId);
            roleMenuMapper.insert(roleMenuKey);
        }
        return new Result();
    }

    @Override
    public Result bindOperations(String roleId, String operationIds) {
        String[] oIds=operationIds.split(",");
        for(String oId:oIds){
            RoleOperationKey roleOperationKey=new RoleOperationKey();
            roleOperationKey.setOperationId(oId);
            roleOperationKey.setRoleId(roleId);
            roleOperationMapper.insert(roleOperationKey);
        }
        return new Result();
    }

    @Override
    public Result bindResources(String roleId, String resourceIds) {
        String[] rIds=resourceIds.split(",");
        for(String rId:rIds){
            RoleResourceKey roleResourceKey=new RoleResourceKey();
            roleResourceKey.setResourceId(rId);
            roleResourceKey.setRoleId(roleId);
            roleResourceMapper.insert(roleResourceKey);
        }
        return new Result();
    }

}
