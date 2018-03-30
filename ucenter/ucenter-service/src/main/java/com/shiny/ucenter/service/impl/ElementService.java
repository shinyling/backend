package com.shiny.ucenter.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.shiny.ucenter.api.ElementApi;
import com.shiny.ucenter.common.dto.Result;
import com.shiny.ucenter.common.entity.Element;
import com.shiny.ucenter.common.entity.ElementExample;
import com.shiny.ucenter.common.entity.RoleElementExample;
import com.shiny.ucenter.common.entity.RoleElementKey;
import com.shiny.ucenter.mapper.ElementMapper;
import com.shiny.ucenter.mapper.RoleElementMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author shiny
 **/
@Service(version = "1.0.0")
public class ElementService implements ElementApi {

    @Autowired
    private RoleElementMapper roleElementMapper;

    @Autowired
    private ElementMapper elementMapper;

    @Override
    public Result findElementsByRoleId(String roleId) {
        RoleElementExample roleElementExample=new RoleElementExample();
        roleElementExample.createCriteria().andRoleIdEqualTo(roleId);
        List<RoleElementKey> roleElementKeys=roleElementMapper.selectByExample(roleElementExample);
        List<Element> elements=new ArrayList<>(roleElementKeys.size());
        for(RoleElementKey roleElement:roleElementKeys){
            String elementId=roleElement.getElementId();
            Element element=elementMapper.selectByPrimaryKey(elementId);
            elements.add(element);
        }
        return new Result(elements);
    }

    @Override
    public Result findAllElements() {
        return new Result(elementMapper.selectByExample(null));
    }

    @Override
    public Result addElement(Element element) {
        ElementExample elementExample=new ElementExample();
        elementExample.createCriteria().andCodeEqualTo(element.getCode());
        List<Element> elements=elementMapper.selectByExample(elementExample);
        if(elements!=null&&elements.size()>0){
            return new Result("此元素已存在");
        }else {
            element.setId(UUID.randomUUID().toString());
            return new Result(elementMapper.insert(element));
        }
    }
}
