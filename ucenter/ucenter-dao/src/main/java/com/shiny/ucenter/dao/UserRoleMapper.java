package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.UserRoleKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

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
}