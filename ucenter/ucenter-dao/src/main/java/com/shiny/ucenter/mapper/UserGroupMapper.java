package com.shiny.ucenter.mapper;

import com.shiny.ucenter.common.entity.UserGroup;
import com.shiny.ucenter.common.entity.UserGroupExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface UserGroupMapper {
    @Delete({
        "delete from user_group",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into user_group (id, name, ",
        "pid)",
        "values (#{id,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{pid,jdbcType=VARCHAR})"
    })
    int insert(UserGroup record);

    @InsertProvider(type=UserGroupSqlProvider.class, method="insertSelective")
    int insertSelective(UserGroup record);

    @SelectProvider(type=UserGroupSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="pid", property="pid", jdbcType=JdbcType.VARCHAR)
    })
    List<UserGroup> selectByExample(UserGroupExample example);

    @Select({
        "select",
        "id, name, pid",
        "from user_group",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="pid", property="pid", jdbcType=JdbcType.VARCHAR)
    })
    UserGroup selectByPrimaryKey(String id);

    @UpdateProvider(type=UserGroupSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserGroup record);

    @Update({
        "update user_group",
        "set name = #{name,jdbcType=VARCHAR},",
          "pid = #{pid,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(UserGroup record);
}