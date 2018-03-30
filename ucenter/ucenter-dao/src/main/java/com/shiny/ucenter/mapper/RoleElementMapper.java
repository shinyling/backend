package com.shiny.ucenter.mapper;

import com.shiny.ucenter.common.entity.RoleElementExample;
import com.shiny.ucenter.common.entity.RoleElementKey;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface RoleElementMapper {
    @Delete({
        "delete from role_element",
        "where role_id = #{roleId,jdbcType=VARCHAR}",
          "and element_id = #{elementId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(RoleElementKey key);

    @Insert({
        "insert into role_element (role_id, element_id)",
        "values (#{roleId,jdbcType=VARCHAR}, #{elementId,jdbcType=VARCHAR})"
    })
    int insert(RoleElementKey record);

    @InsertProvider(type=RoleElementSqlProvider.class, method="insertSelective")
    int insertSelective(RoleElementKey record);

    @SelectProvider(type=RoleElementSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="element_id", property="elementId", jdbcType=JdbcType.VARCHAR, id=true)
    })
    List<RoleElementKey> selectByExample(RoleElementExample example);
}