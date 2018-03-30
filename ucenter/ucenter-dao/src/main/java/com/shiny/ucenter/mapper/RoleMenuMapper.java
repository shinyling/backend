package com.shiny.ucenter.mapper;

import com.shiny.ucenter.common.entity.RoleMenuExample;
import com.shiny.ucenter.common.entity.RoleMenuKey;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface RoleMenuMapper {
    @Delete({
        "delete from role_menu",
        "where menu_id = #{menuId,jdbcType=VARCHAR}",
          "and role_id = #{roleId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(RoleMenuKey key);

    @Insert({
        "insert into role_menu (menu_id, role_id)",
        "values (#{menuId,jdbcType=VARCHAR}, #{roleId,jdbcType=VARCHAR})"
    })
    int insert(RoleMenuKey record);

    @InsertProvider(type=RoleMenuSqlProvider.class, method="insertSelective")
    int insertSelective(RoleMenuKey record);

    @SelectProvider(type=RoleMenuSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="menu_id", property="menuId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.VARCHAR, id=true)
    })
    List<RoleMenuKey> selectByExample(RoleMenuExample example);
}