package com.shiny.ucenter.dao;

import com.shiny.ucenter.common.entity.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author shiny
 **/
public interface UserRoleDao {

    @Select("select r.id,r.name from user_role ur left join role r on ur.role_id=r.id where ur.user_id=#{userId}")
    List<Role> selectRolesByUid(String userId);
}
