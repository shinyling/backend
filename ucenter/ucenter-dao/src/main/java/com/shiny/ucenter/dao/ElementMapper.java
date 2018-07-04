package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.Element;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ElementMapper {
    @Delete({
        "delete from element",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into element (id, name, ",
        "code)",
        "values (#{id,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{code,jdbcType=VARCHAR})"
    })
    int insert(Element record);

    @InsertProvider(type=ElementSqlProvider.class, method="insertSelective")
    int insertSelective(Element record);

    @Select({
        "select",
        "id, name, code",
        "from element",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR)
    })
    Element selectByPrimaryKey(String id);

    @UpdateProvider(type=ElementSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Element record);

    @Update({
        "update element",
        "set name = #{name,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Element record);
}