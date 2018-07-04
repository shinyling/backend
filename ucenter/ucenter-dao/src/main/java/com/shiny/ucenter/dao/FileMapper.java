package com.shiny.ucenter.dao;

import com.shiny.ucenter.entity.File;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface FileMapper {
    @Delete({
        "delete from file",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into file (id, name, ",
        "url, size, create_time, ",
        "create_by)",
        "values (#{id,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{url,jdbcType=VARCHAR}, #{size,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{createBy,jdbcType=VARCHAR})"
    })
    int insert(File record);

    @InsertProvider(type=FileSqlProvider.class, method="insertSelective")
    int insertSelective(File record);

    @Select({
        "select",
        "id, name, url, size, create_time, create_by",
        "from file",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="size", property="size", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR)
    })
    File selectByPrimaryKey(String id);

    @UpdateProvider(type=FileSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(File record);

    @Update({
        "update file",
        "set name = #{name,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "size = #{size,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "create_by = #{createBy,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(File record);
}