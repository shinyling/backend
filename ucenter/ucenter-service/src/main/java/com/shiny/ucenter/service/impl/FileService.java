package com.shiny.ucenter.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.shiny.ucenter.api.FileApi;
import com.shiny.ucenter.common.dto.Result;
import com.shiny.ucenter.common.entity.File;
import com.shiny.ucenter.dao.FileDao;
import com.shiny.ucenter.mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * @author shiny
 **/
@Service(version = "1.0.0")
public class FileService implements FileApi{

    @Autowired
    private FileMapper fileMapper;

    @Autowired
    private FileDao fileDao;

    @Override
    public Result uploadFile(File file) {
        file.setId(UUID.randomUUID().toString());
        return new Result(fileMapper.insert(file));
    }

    @Override
    public Result listFileByRoleId(String roleId) {
        return new Result(fileDao.selectByRoleId(roleId));
    }
}
