package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.RolePermissionKey;
import org.apache.ibatis.jdbc.SQL;

public class RolePermissionSqlProvider {

    public String insertSelective(RolePermissionKey record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("role_permission");
        
        if (record.getRoleId() != null) {
            sql.VALUES("role_id", "#{roleId,jdbcType=VARCHAR}");
        }
        
        if (record.getPermissionId() != null) {
            sql.VALUES("permission_id", "#{permissionId,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }
}