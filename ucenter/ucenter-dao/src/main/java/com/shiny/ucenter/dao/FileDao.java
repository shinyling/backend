package com.shiny.ucenter.dao;

import com.shiny.ucenter.common.entity.File;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author shiny
 **/
@Mapper
public interface FileDao {

    @Select("select f.* from role_file rf left join file f on rf.file_id=f.id where rf.role_id=#{roleId}")
    List<File> selectByRoleId(String roleId);
}
