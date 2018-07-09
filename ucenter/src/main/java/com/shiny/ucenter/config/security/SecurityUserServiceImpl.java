package com.shiny.ucenter.config.security;

import com.shiny.ucenter.dao.RoleMapper;
import com.shiny.ucenter.dao.UserMapper;
import com.shiny.ucenter.dao.UserRoleMapper;
import com.shiny.ucenter.entity.Role;
import com.shiny.ucenter.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DELL shiny
 * @create 2018/7/5
 */
@Service
public class SecurityUserServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userMapper.selectByMobile(username);
        if(user==null){
            throw new UsernameNotFoundException("用户不存在");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        List<String> roleId=userRoleMapper.selectRoleIdsByUserId(user.getId());
        if(roleId!=null&&roleId.size()>0) {
            List<Role> roles = roleMapper.selectByIds(roleId);
            for (Role role : roles) {
                authorities.add(new SimpleGrantedAuthority(role.getEnCode()));
            }
        }
        SecurityUser securityUser=new SecurityUser(username,user.getPassword(),authorities);
        return securityUser;
    }
}
