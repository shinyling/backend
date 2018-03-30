package com.shiny.ucenter.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.shiny.ucenter.api.OperationApi;
import com.shiny.ucenter.common.dto.Result;
import com.shiny.ucenter.common.entity.Operation;
import com.shiny.ucenter.common.entity.OperationExample;
import com.shiny.ucenter.mapper.OperationMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

/**
 * @author shiny
 **/
@Service(version = "1.0.0")
public class OperationService implements OperationApi {

    @Autowired
    private OperationMapper operationMapper;

    @Override
    public Result addOperation(Operation operation) {
        OperationExample example=new OperationExample();
        example.createCriteria().andCodeEqualTo(operation.getCode())
        .andNameEqualTo(operation.getName());
        List<Operation> operationList=operationMapper.selectByExample(example);
        if(operationList!=null&&operationList.size()>0){
            return new Result("此条目已存在!");
        }
        operation.setId(UUID.randomUUID().toString());
        return new Result(operationMapper.insert(operation));
    }
}
