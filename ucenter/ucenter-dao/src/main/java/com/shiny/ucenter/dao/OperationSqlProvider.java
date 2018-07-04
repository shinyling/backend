package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.Operation;
import org.apache.ibatis.jdbc.SQL;

public class OperationSqlProvider {

    public String insertSelective(Operation record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("operation");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            sql.VALUES("code", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getUrlPrefix() != null) {
            sql.VALUES("url_prefix", "#{urlPrefix,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Operation record) {
        SQL sql = new SQL();
        sql.UPDATE("operation");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            sql.SET("code = #{code,jdbcType=VARCHAR}");
        }
        
        if (record.getUrlPrefix() != null) {
            sql.SET("url_prefix = #{urlPrefix,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return sql.toString();
    }
}