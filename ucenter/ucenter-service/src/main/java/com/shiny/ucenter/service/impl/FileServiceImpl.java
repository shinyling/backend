package com.shiny.ucenter.service.impl;

import com.shiny.ucenter.common.entity.File;
import com.shiny.ucenter.mapper.FileMapper;
import com.shiny.ucenter.common.service.FileService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shiny
 * @since 2018-05-02
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {
	
}
