package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.PermissionFileKey;
import org.apache.ibatis.jdbc.SQL;

public class PermissionFileSqlProvider {

    public String insertSelective(PermissionFileKey record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("permission_file");
        
        if (record.getPermissionId() != null) {
            sql.VALUES("permission_id", "#{permissionId,jdbcType=VARCHAR}");
        }
        
        if (record.getFileId() != null) {
            sql.VALUES("file_id", "#{fileId,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }
}