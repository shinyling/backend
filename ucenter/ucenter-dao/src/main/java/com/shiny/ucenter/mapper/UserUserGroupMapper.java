package com.shiny.ucenter.mapper;

import com.shiny.ucenter.common.entity.UserUserGroupExample;
import com.shiny.ucenter.common.entity.UserUserGroupKey;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface UserUserGroupMapper {
    @Delete({
        "delete from user_user_group",
        "where group_id = #{groupId,jdbcType=VARCHAR}",
          "and user_id = #{userId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(UserUserGroupKey key);

    @Insert({
        "insert into user_user_group (group_id, user_id)",
        "values (#{groupId,jdbcType=VARCHAR}, #{userId,jdbcType=VARCHAR})"
    })
    int insert(UserUserGroupKey record);

    @InsertProvider(type=UserUserGroupSqlProvider.class, method="insertSelective")
    int insertSelective(UserUserGroupKey record);

    @SelectProvider(type=UserUserGroupSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR, id=true)
    })
    List<UserUserGroupKey> selectByExample(UserUserGroupExample example);
}