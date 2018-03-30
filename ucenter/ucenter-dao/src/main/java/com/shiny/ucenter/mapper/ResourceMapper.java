package com.shiny.ucenter.mapper;

import com.shiny.ucenter.common.entity.Resource;
import com.shiny.ucenter.common.entity.ResourceExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ResourceMapper {
    @Delete({
        "delete from resource",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into resource (id, name, ",
        "type)",
        "values (#{id,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=VARCHAR})"
    })
    int insert(Resource record);

    @InsertProvider(type=ResourceSqlProvider.class, method="insertSelective")
    int insertSelective(Resource record);

    @SelectProvider(type=ResourceSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR)
    })
    List<Resource> selectByExample(ResourceExample example);

    @Select({
        "select",
        "id, name, type",
        "from resource",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR)
    })
    Resource selectByPrimaryKey(String id);

    @UpdateProvider(type=ResourceSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Resource record);

    @Update({
        "update resource",
        "set name = #{name,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Resource record);
}