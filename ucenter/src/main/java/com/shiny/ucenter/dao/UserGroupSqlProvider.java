package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.UserGroup;
import org.apache.ibatis.jdbc.SQL;

public class UserGroupSqlProvider {

    public String insertSelective(UserGroup record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user_group");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPid() != null) {
            sql.VALUES("pid", "#{pid,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(UserGroup record) {
        SQL sql = new SQL();
        sql.UPDATE("user_group");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPid() != null) {
            sql.SET("pid = #{pid,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return sql.toString();
    }
}