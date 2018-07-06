package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.UserRoleKey;
import org.apache.ibatis.jdbc.SQL;

public class UserRoleSqlProvider {

    public String insertSelective(UserRoleKey record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user_role");
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=VARCHAR}");
        }
        
        if (record.getRoleId() != null) {
            sql.VALUES("role_id", "#{roleId,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }
}