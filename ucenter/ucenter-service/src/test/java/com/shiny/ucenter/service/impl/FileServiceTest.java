package com.shiny.ucenter.service.impl;

import com.shiny.ucenter.common.entity.File;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileServiceTest {

    @Autowired
    private FileService fileService;

    @Test
    public void uploadFile() throws Exception {
        File file=new File();
        file.setName("文件测试");
        file.setPath("/sds/ssd/sd.txt");
        fileService.uploadFile(file);
    }

}