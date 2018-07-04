package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.Element;
import org.apache.ibatis.jdbc.SQL;

public class ElementSqlProvider {

    public String insertSelective(Element record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("element");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            sql.VALUES("code", "#{code,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Element record) {
        SQL sql = new SQL();
        sql.UPDATE("element");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            sql.SET("code = #{code,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return sql.toString();
    }
}