package com.shiny.ucenter.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shiny.ucenter.api.FileApi;
import com.shiny.ucenter.common.dto.Result;
import com.shiny.ucenter.common.entity.File;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shiny
 **/
@RestController
@RequestMapping("file")
public class FileController {

    @Reference(version = "1.0.0")
    private FileApi fileApi;

    @PostMapping("add")
    public Result addFile(File file){
        return fileApi.uploadFile(file);
    }
}
