package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.PermissionFileKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

public interface PermissionFileMapper {
    @Delete({
        "delete from permission_file",
        "where permission_id = #{permissionId,jdbcType=VARCHAR}",
          "and file_id = #{fileId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(PermissionFileKey key);

    @Insert({
        "insert into permission_file (permission_id, file_id)",
        "values (#{permissionId,jdbcType=VARCHAR}, #{fileId,jdbcType=VARCHAR})"
    })
    int insert(PermissionFileKey record);

    @InsertProvider(type=PermissionFileSqlProvider.class, method="insertSelective")
    int insertSelective(PermissionFileKey record);
}