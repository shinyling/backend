package com.shiny.ucenter.mapper;

import com.shiny.ucenter.common.entity.UserRoleExample;
import com.shiny.ucenter.common.entity.UserRoleKey;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface UserRoleMapper {
    @Delete({
        "delete from user_role",
        "where user_id = #{userId,jdbcType=VARCHAR}",
          "and role_id = #{roleId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(UserRoleKey key);

    @Insert({
        "insert into user_role (user_id, role_id)",
        "values (#{userId,jdbcType=VARCHAR}, #{roleId,jdbcType=VARCHAR})"
    })
    int insert(UserRoleKey record);

    @InsertProvider(type=UserRoleSqlProvider.class, method="insertSelective")
    int insertSelective(UserRoleKey record);

    @SelectProvider(type=UserRoleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.VARCHAR, id=true)
    })
    List<UserRoleKey> selectByExample(UserRoleExample example);
}