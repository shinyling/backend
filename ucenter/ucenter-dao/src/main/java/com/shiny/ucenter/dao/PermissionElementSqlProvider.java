package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.PermissionElementKey;
import org.apache.ibatis.jdbc.SQL;

public class PermissionElementSqlProvider {

    public String insertSelective(PermissionElementKey record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("permission_element");
        
        if (record.getPermissionId() != null) {
            sql.VALUES("permission_id", "#{permissionId,jdbcType=VARCHAR}");
        }
        
        if (record.getElementId() != null) {
            sql.VALUES("element_id", "#{elementId,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }
}