package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.RolePermissionKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

public interface RolePermissionMapper {
    @Delete({
        "delete from role_permission",
        "where role_id = #{roleId,jdbcType=VARCHAR}",
          "and permission_id = #{permissionId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(RolePermissionKey key);

    @Insert({
        "insert into role_permission (role_id, permission_id)",
        "values (#{roleId,jdbcType=VARCHAR}, #{permissionId,jdbcType=VARCHAR})"
    })
    int insert(RolePermissionKey record);

    @InsertProvider(type=RolePermissionSqlProvider.class, method="insertSelective")
    int insertSelective(RolePermissionKey record);
}