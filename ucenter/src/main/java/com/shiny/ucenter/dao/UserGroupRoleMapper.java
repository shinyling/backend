package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.UserGroupRoleKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

public interface UserGroupRoleMapper {
    @Delete({
        "delete from user_group_role",
        "where group_id = #{groupId,jdbcType=VARCHAR}",
          "and role_id = #{roleId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(UserGroupRoleKey key);

    @Insert({
        "insert into user_group_role (group_id, role_id)",
        "values (#{groupId,jdbcType=VARCHAR}, #{roleId,jdbcType=VARCHAR})"
    })
    int insert(UserGroupRoleKey record);

    @InsertProvider(type=UserGroupRoleSqlProvider.class, method="insertSelective")
    int insertSelective(UserGroupRoleKey record);
}