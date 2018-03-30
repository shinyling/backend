package com.shiny.ucenter.api;

import com.shiny.ucenter.common.dto.Result;
import com.shiny.ucenter.common.entity.*;

import java.util.List;

/**
 * @author shiny
 **/
public interface UserApi {

    /**
     * 登录
     * @param mobile 电话号码
     * @return
     */
    Result login(String mobile);

    /**
     * 注册
     * @param user 用户
     * @return
     */
    Result register(User user);

    /**
     * 绑定角色
     * @param userId 用户id
     * @param roles 角色id串
     */
    Result bindRoles(String userId,String roles);

    /**
     * 根据uid查询页面元素
     * @param userId uid
     * @return
     */
    Result listElementByUid(String userId);

    /**
     * 根据uid查询可访问文件
     * @param userId uid
     * @return
     */
    Result listFileByUid(String userId);

    /**
     * 根据uid 查询可访问菜单
     * @param userId uid
     * @return
     */
    Result listMenuByUid(String userId);

    /**
     * 根据uid 查询可执行操作
     * @param userId uid
     * @return
     */
    Result listOperationByUid(String userId);

    /**
     * 根据uid 查询可访问资源
     * @param userId uid
     * @return
     */
    Result listResourceByUid(String userId);

}
