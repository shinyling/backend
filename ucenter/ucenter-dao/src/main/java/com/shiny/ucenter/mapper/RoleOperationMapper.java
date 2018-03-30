package com.shiny.ucenter.mapper;

import com.shiny.ucenter.common.entity.RoleOperationExample;
import com.shiny.ucenter.common.entity.RoleOperationKey;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface RoleOperationMapper {
    @Delete({
        "delete from role_operation",
        "where role_id = #{roleId,jdbcType=VARCHAR}",
          "and operation_id = #{operationId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(RoleOperationKey key);

    @Insert({
        "insert into role_operation (role_id, operation_id)",
        "values (#{roleId,jdbcType=VARCHAR}, #{operationId,jdbcType=VARCHAR})"
    })
    int insert(RoleOperationKey record);

    @InsertProvider(type=RoleOperationSqlProvider.class, method="insertSelective")
    int insertSelective(RoleOperationKey record);

    @SelectProvider(type=RoleOperationSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="operation_id", property="operationId", jdbcType=JdbcType.VARCHAR, id=true)
    })
    List<RoleOperationKey> selectByExample(RoleOperationExample example);
}