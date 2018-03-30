package com.shiny.ucenter.mapper;

import com.shiny.ucenter.common.entity.RoleResourceExample;
import com.shiny.ucenter.common.entity.RoleResourceKey;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface RoleResourceMapper {
    @Delete({
        "delete from role_resource",
        "where role_id = #{roleId,jdbcType=VARCHAR}",
          "and resource_id = #{resourceId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(RoleResourceKey key);

    @Insert({
        "insert into role_resource (role_id, resource_id)",
        "values (#{roleId,jdbcType=VARCHAR}, #{resourceId,jdbcType=VARCHAR})"
    })
    int insert(RoleResourceKey record);

    @InsertProvider(type=RoleResourceSqlProvider.class, method="insertSelective")
    int insertSelective(RoleResourceKey record);

    @SelectProvider(type=RoleResourceSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="resource_id", property="resourceId", jdbcType=JdbcType.VARCHAR, id=true)
    })
    List<RoleResourceKey> selectByExample(RoleResourceExample example);
}