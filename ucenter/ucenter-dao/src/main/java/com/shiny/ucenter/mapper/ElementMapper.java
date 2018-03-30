package com.shiny.ucenter.mapper;

import com.shiny.ucenter.common.entity.Element;
import com.shiny.ucenter.common.entity.ElementExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ElementMapper {
    @Delete({
        "delete from element",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into element (id, description, ",
        "code)",
        "values (#{id,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{code,jdbcType=VARCHAR})"
    })
    int insert(Element record);

    @InsertProvider(type=ElementSqlProvider.class, method="insertSelective")
    int insertSelective(Element record);

    @SelectProvider(type=ElementSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR)
    })
    List<Element> selectByExample(ElementExample example);

    @Select({
        "select",
        "id, description, code",
        "from element",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR)
    })
    Element selectByPrimaryKey(String id);

    @UpdateProvider(type=ElementSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Element record);

    @Update({
        "update element",
        "set description = #{description,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Element record);
}