package com.shiny.ucenter.dao;

import com.shiny.ucenter.common.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author shiny
 **/
@Mapper
public interface UserDao {

    @Select("select * from user where mobile=#{mobile}")
    User selectByMobile(String mobile);

    @Insert("insert into user(id,name,mobile) values(uuid(),#{name},#{mobile})")
    User insert(User user);

    @Select("select distinct e.id,e.description,e.code from user_role ur left join role r on ur.role_id=r.id left join role_element re on r.id=re.role_id left join" +
            " element e on re.element_id=e.id where ur.user_id=#{userId}")
    List<Element> selectElementByUid(String userId);

    @Select("select distinct f.id,f.name,f.path from user_role ur left join role r on ur.role_id=r.id left join role_file rf on r.id=rf.role_id left join" +
            " file f on rf.file_id=f.id where ur.user_id=#{userId}")
    List<File> selectFileByUid(String userId);

    @Select("select distinct m.id,m.name,m.url,m.pid from user_role ur left join role r on ur.role_id=r.id left join role_menu rm on r.id=rm.role_id left join" +
            " menu m on rm.menu_id=m.id where ur.user_id=#{userId}")
    List<Menu> selectMenuByUid(String userId);

    @Select("select distinct o.id,o.name,o.code,o.url_prefix from user_role ur left join role r on ur.role_id=r.id left join role_operation ro on r.id=ro.role_id left join" +
            " operation o on ro.operation_id=o.id where ur.user_id=#{userId}")
    List<Operation> selectOperationByUid(String userId);

    @Select("select distinct r.id,r.name,r.type from user_role ur left join role r on ur.role_id=r.id left join role_resource rr on r.id=rr.role_id left join" +
            " resource r on rr.resource_id=r.id where ur.user_id=#{userId}")
    List<Resource> selectResourceByUid(String userId);
}
