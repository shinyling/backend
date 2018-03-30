package com.shiny.ucenter.mapper;

import com.shiny.ucenter.common.entity.RoleFileExample;
import com.shiny.ucenter.common.entity.RoleFileKey;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface RoleFileMapper {
    @Delete({
        "delete from role_file",
        "where file_id = #{fileId,jdbcType=VARCHAR}",
          "and role_id = #{roleId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(RoleFileKey key);

    @Insert({
        "insert into role_file (file_id, role_id)",
        "values (#{fileId,jdbcType=VARCHAR}, #{roleId,jdbcType=VARCHAR})"
    })
    int insert(RoleFileKey record);

    @InsertProvider(type=RoleFileSqlProvider.class, method="insertSelective")
    int insertSelective(RoleFileKey record);

    @SelectProvider(type=RoleFileSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="file_id", property="fileId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.VARCHAR, id=true)
    })
    List<RoleFileKey> selectByExample(RoleFileExample example);
}