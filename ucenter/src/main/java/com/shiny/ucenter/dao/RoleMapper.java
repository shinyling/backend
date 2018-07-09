package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface RoleMapper {
    @Delete({
        "delete from role",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into role (id, name, ",
        "en_code)",
        "values (#{id,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{enCode,jdbcType=VARCHAR})"
    })
    int insert(Role record);

    @InsertProvider(type=RoleSqlProvider.class, method="insertSelective")
    int insertSelective(Role record);

    @Select({
        "select",
        "id, name, en_code",
        "from role",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="en_code", property="enCode", jdbcType=JdbcType.VARCHAR)
    })
    Role selectByPrimaryKey(String id);

    @UpdateProvider(type=RoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Role record);

    @Update({
        "update role",
        "set name = #{name,jdbcType=VARCHAR},",
          "en_code = #{enCode,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Role record);

    @Select("<script>" +
            "SELECT id,name,en_code enCode from role where id in " +
            "<foreach item='item' index='index' collection='roleIds' open='(' separator=',' close=')'>" +
                    "#{item}" +
            "</foreach>" +
            "</script>" )
    List<Role> selectByIds(@Param("roleIds") List<String> roleIds);
}