package com.shiny.ucenter.mapper;

import com.shiny.ucenter.common.entity.File;
import com.shiny.ucenter.common.entity.FileExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface FileMapper {
    @Delete({
        "delete from file",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into file (id, name, ",
        "path)",
        "values (#{id,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{path,jdbcType=VARCHAR})"
    })
    int insert(File record);

    @InsertProvider(type=FileSqlProvider.class, method="insertSelective")
    int insertSelective(File record);

    @SelectProvider(type=FileSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR)
    })
    List<File> selectByExample(FileExample example);

    @Select({
        "select",
        "id, name, path",
        "from file",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR)
    })
    File selectByPrimaryKey(String id);

    @UpdateProvider(type=FileSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(File record);

    @Update({
        "update file",
        "set name = #{name,jdbcType=VARCHAR},",
          "path = #{path,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(File record);
}