package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.Operation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface OperationMapper {
    @Delete({
        "delete from operation",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into operation (id, name, ",
        "code, url_prefix)",
        "values (#{id,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{code,jdbcType=VARCHAR}, #{urlPrefix,jdbcType=VARCHAR})"
    })
    int insert(Operation record);

    @InsertProvider(type=OperationSqlProvider.class, method="insertSelective")
    int insertSelective(Operation record);

    @Select({
        "select",
        "id, name, code, url_prefix",
        "from operation",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="url_prefix", property="urlPrefix", jdbcType=JdbcType.VARCHAR)
    })
    Operation selectByPrimaryKey(String id);

    @UpdateProvider(type=OperationSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Operation record);

    @Update({
        "update operation",
        "set name = #{name,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR},",
          "url_prefix = #{urlPrefix,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Operation record);
}