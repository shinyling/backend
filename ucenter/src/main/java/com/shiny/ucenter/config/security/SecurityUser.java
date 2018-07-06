package com.shiny.ucenter.config.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author DELL shiny
 * @create 2018/7/5
 */
public class SecurityUser extends User implements UserDetails{

    public SecurityUser(String username,String password,Collection<? extends GrantedAuthority> authorities){
        super(username,password,authorities);
    }

}
