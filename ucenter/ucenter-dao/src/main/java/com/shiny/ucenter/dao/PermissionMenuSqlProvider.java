package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.PermissionMenu;
import org.apache.ibatis.jdbc.SQL;

public class PermissionMenuSqlProvider {

    public String insertSelective(PermissionMenu record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("permission_menu");
        
        if (record.getPermissionId() != null) {
            sql.VALUES("permission_id", "#{permissionId,jdbcType=VARCHAR}");
        }
        
        if (record.getMenuId() != null) {
            sql.VALUES("menu_id", "#{menuId,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(PermissionMenu record) {
        SQL sql = new SQL();
        sql.UPDATE("permission_menu");
        
        if (record.getMenuId() != null) {
            sql.SET("menu_id = #{menuId,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("permission_id = #{permissionId,jdbcType=VARCHAR}");
        
        return sql.toString();
    }
}