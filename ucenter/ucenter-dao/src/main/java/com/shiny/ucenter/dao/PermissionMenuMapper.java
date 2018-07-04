package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.PermissionMenu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface PermissionMenuMapper {
    @Delete({
        "delete from permission_menu",
        "where permission_id = #{permissionId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String permissionId);

    @Insert({
        "insert into permission_menu (permission_id, menu_id)",
        "values (#{permissionId,jdbcType=VARCHAR}, #{menuId,jdbcType=VARCHAR})"
    })
    int insert(PermissionMenu record);

    @InsertProvider(type=PermissionMenuSqlProvider.class, method="insertSelective")
    int insertSelective(PermissionMenu record);

    @Select({
        "select",
        "permission_id, menu_id",
        "from permission_menu",
        "where permission_id = #{permissionId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="permission_id", property="permissionId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="menu_id", property="menuId", jdbcType=JdbcType.VARCHAR)
    })
    PermissionMenu selectByPrimaryKey(String permissionId);

    @UpdateProvider(type=PermissionMenuSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PermissionMenu record);

    @Update({
        "update permission_menu",
        "set menu_id = #{menuId,jdbcType=VARCHAR}",
        "where permission_id = #{permissionId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(PermissionMenu record);
}