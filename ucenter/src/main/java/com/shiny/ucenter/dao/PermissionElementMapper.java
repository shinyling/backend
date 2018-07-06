package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.PermissionElementKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

public interface PermissionElementMapper {
    @Delete({
        "delete from permission_element",
        "where permission_id = #{permissionId,jdbcType=VARCHAR}",
          "and element_id = #{elementId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(PermissionElementKey key);

    @Insert({
        "insert into permission_element (permission_id, element_id)",
        "values (#{permissionId,jdbcType=VARCHAR}, #{elementId,jdbcType=VARCHAR})"
    })
    int insert(PermissionElementKey record);

    @InsertProvider(type=PermissionElementSqlProvider.class, method="insertSelective")
    int insertSelective(PermissionElementKey record);
}