package com.shiny.ucenter.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.shiny.ucenter.api.ResourceApi;
import com.shiny.ucenter.common.dto.Result;
import com.shiny.ucenter.common.entity.Resource;
import com.shiny.ucenter.common.entity.ResourceExample;
import com.shiny.ucenter.mapper.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

/**
 * @author shiny
 **/
@Service(version = "1.0.0")
public class ResourceService implements ResourceApi {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public Result addResource(Resource resource) {
        ResourceExample resourceExample=new ResourceExample();
        resourceExample.createCriteria().andNameEqualTo(resource.getName()).andTypeEqualTo(resource.getType());
        List<Resource> resourceList=resourceMapper.selectByExample(resourceExample);
        if(resourceList!=null&&resourceList.size()>0){
            return new Result("信息已存在!");
        }
        resource.setId(UUID.randomUUID().toString());
        return new Result(resourceMapper.insert(resource));
    }
}
