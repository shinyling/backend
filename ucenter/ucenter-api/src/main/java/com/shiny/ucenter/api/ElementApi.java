package com.shiny.ucenter.api;

import com.shiny.ucenter.common.dto.Result;
import com.shiny.ucenter.common.entity.Element;

/**
 * @author shiny
 **/
public interface ElementApi {
    /**
     * 通过角色id 查找页面元素
     * @param roleId 角色id
     * @return
     */
    Result findElementsByRoleId(String roleId);

    /**
     * 列出所有页面元素
     * @return
     */
    Result findAllElements();

    /**
     * 新增页面元素
     * @param element 页面元素
     * @return
     */
    Result addElement(Element element);
}
