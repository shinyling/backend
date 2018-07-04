package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.PermissionOperation;
import org.apache.ibatis.jdbc.SQL;

public class PermissionOperationSqlProvider {

    public String insertSelective(PermissionOperation record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("permission_operation");
        
        if (record.getPermissionId() != null) {
            sql.VALUES("permission_id", "#{permissionId,jdbcType=VARCHAR}");
        }
        
        if (record.getOperationId() != null) {
            sql.VALUES("operation_id", "#{operationId,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(PermissionOperation record) {
        SQL sql = new SQL();
        sql.UPDATE("permission_operation");
        
        if (record.getOperationId() != null) {
            sql.SET("operation_id = #{operationId,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("permission_id = #{permissionId,jdbcType=VARCHAR}");
        
        return sql.toString();
    }
}