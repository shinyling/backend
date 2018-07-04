package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.PermissionOperation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface PermissionOperationMapper {
    @Delete({
        "delete from permission_operation",
        "where permission_id = #{permissionId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String permissionId);

    @Insert({
        "insert into permission_operation (permission_id, operation_id)",
        "values (#{permissionId,jdbcType=VARCHAR}, #{operationId,jdbcType=VARCHAR})"
    })
    int insert(PermissionOperation record);

    @InsertProvider(type=PermissionOperationSqlProvider.class, method="insertSelective")
    int insertSelective(PermissionOperation record);

    @Select({
        "select",
        "permission_id, operation_id",
        "from permission_operation",
        "where permission_id = #{permissionId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="permission_id", property="permissionId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="operation_id", property="operationId", jdbcType=JdbcType.VARCHAR)
    })
    PermissionOperation selectByPrimaryKey(String permissionId);

    @UpdateProvider(type=PermissionOperationSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PermissionOperation record);

    @Update({
        "update permission_operation",
        "set operation_id = #{operationId,jdbcType=VARCHAR}",
        "where permission_id = #{permissionId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(PermissionOperation record);
}