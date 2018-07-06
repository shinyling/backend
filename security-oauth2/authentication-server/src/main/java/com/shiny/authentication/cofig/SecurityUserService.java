package com.shiny.authentication.cofig;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author DELL shiny
 * @create 2018/7/6
 */
@Service
public class SecurityUserService implements UserDetailsService{


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                List<GrantedAuthority> grantedAuthorityList=new ArrayList();
                GrantedAuthority grantedAuthority=new GrantedAuthority() {
                    @Override
                    public String getAuthority() {
                        return "ADMIN";
                    }
                };
                grantedAuthorityList.add(grantedAuthority);
                return grantedAuthorityList;
            }

            @Override
            public String getPassword() {
                return "123456";
            }

            @Override
            public String getUsername() {
                return "admin";
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }
}
