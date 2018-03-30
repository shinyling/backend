package com.shiny.ucenter.api;

import com.shiny.ucenter.common.dto.Result;
import com.shiny.ucenter.common.entity.Role;

/**
 * @author shiny
 **/
public interface RoleApi {

    Result addRole(Role role);

    Result findRolesByUid(String uid);

    Result bindElements(String roleId,String elementIds);

    Result bindFiles(String roleId,String fileIds);

    Result bindMenus(String roleId,String menuIds);

    Result bindOperations(String roleId,String operationIds);

    Result bindResources(String roleId,String resourceIds);

}
