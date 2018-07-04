package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface PermissionMapper {
    @Delete({
        "delete from permission",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into permission (id, name, ",
        "type, permission_val, ",
        "uri, icon)",
        "values (#{id,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=BIT}, #{permissionVal,jdbcType=VARCHAR}, ",
        "#{uri,jdbcType=VARCHAR}, #{icon,jdbcType=VARCHAR})"
    })
    int insert(Permission record);

    @InsertProvider(type=PermissionSqlProvider.class, method="insertSelective")
    int insertSelective(Permission record);

    @Select({
        "select",
        "id, name, type, permission_val, uri, icon",
        "from permission",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.BIT),
        @Result(column="permission_val", property="permissionVal", jdbcType=JdbcType.VARCHAR),
        @Result(column="uri", property="uri", jdbcType=JdbcType.VARCHAR),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR)
    })
    Permission selectByPrimaryKey(String id);

    @UpdateProvider(type=PermissionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Permission record);

    @Update({
        "update permission",
        "set name = #{name,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=BIT},",
          "permission_val = #{permissionVal,jdbcType=VARCHAR},",
          "uri = #{uri,jdbcType=VARCHAR},",
          "icon = #{icon,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Permission record);
}