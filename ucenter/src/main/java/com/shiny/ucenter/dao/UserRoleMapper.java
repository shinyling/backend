package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.UserRoleKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

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

    @Select("select role_id roleId from user_role where user_id=#{userId}")
    List<String> selectRoleIdsByUserId(String userId);
}