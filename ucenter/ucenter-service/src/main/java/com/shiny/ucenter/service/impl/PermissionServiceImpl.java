package com.shiny.ucenter.service.impl;

import com.shiny.ucenter.common.entity.Permission;
import com.shiny.ucenter.mapper.PermissionMapper;
import com.shiny.ucenter.common.service.PermissionService;
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
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
	
}
