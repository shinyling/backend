package com.shiny.ucenter.service.impl;

import com.shiny.ucenter.common.entity.User;
import com.shiny.ucenter.mapper.UserMapper;
import com.shiny.ucenter.common.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
	
}
