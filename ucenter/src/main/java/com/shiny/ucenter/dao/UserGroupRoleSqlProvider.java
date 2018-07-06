package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.UserGroupRoleKey;
import org.apache.ibatis.jdbc.SQL;

public class UserGroupRoleSqlProvider {

    public String insertSelective(UserGroupRoleKey record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user_group_role");
        
        if (record.getGroupId() != null) {
            sql.VALUES("group_id", "#{groupId,jdbcType=VARCHAR}");
        }
        
        if (record.getRoleId() != null) {
            sql.VALUES("role_id", "#{roleId,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }
}