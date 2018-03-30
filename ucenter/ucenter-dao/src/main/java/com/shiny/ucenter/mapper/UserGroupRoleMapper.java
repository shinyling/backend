package com.shiny.ucenter.mapper;

import com.shiny.ucenter.common.entity.UserGroupRoleExample;
import com.shiny.ucenter.common.entity.UserGroupRoleKey;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

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

    @SelectProvider(type=UserGroupRoleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.VARCHAR, id=true)
    })
    List<UserGroupRoleKey> selectByExample(UserGroupRoleExample example);
}