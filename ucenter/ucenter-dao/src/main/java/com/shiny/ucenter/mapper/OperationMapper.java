package com.shiny.ucenter.mapper;

import com.shiny.ucenter.common.entity.Operation;
import com.shiny.ucenter.common.entity.OperationExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface OperationMapper {
    @Delete({
        "delete from operation",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into operation (id, name, ",
        "code, url_prefix, ",
        "pid)",
        "values (#{id,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{code,jdbcType=VARCHAR}, #{urlPrefix,jdbcType=VARCHAR}, ",
        "#{pid,jdbcType=VARCHAR})"
    })
    int insert(Operation record);

    @InsertProvider(type=OperationSqlProvider.class, method="insertSelective")
    int insertSelective(Operation record);

    @SelectProvider(type=OperationSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="url_prefix", property="urlPrefix", jdbcType=JdbcType.VARCHAR),
        @Result(column="pid", property="pid", jdbcType=JdbcType.VARCHAR)
    })
    List<Operation> selectByExample(OperationExample example);

    @Select({
        "select",
        "id, name, code, url_prefix, pid",
        "from operation",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="url_prefix", property="urlPrefix", jdbcType=JdbcType.VARCHAR),
        @Result(column="pid", property="pid", jdbcType=JdbcType.VARCHAR)
    })
    Operation selectByPrimaryKey(String id);

    @UpdateProvider(type=OperationSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Operation record);

    @Update({
        "update operation",
        "set name = #{name,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR},",
          "url_prefix = #{urlPrefix,jdbcType=VARCHAR},",
          "pid = #{pid,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Operation record);
}