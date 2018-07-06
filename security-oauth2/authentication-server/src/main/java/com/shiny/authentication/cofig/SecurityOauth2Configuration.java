package com.shiny.authentication.cofig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * @author DELL shiny
 * @create 2018/7/6
 */
@Configuration
@EnableAuthorizationServer
public class SecurityOauth2Configuration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SecurityUserService securityUserService;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("admin")
                .secret("shiny")
                .accessTokenValiditySeconds(2000)        // expire time for access token
                .refreshTokenValiditySeconds(-1)         // expire time for refresh token
                .scopes("read", "write")                         // scope related to resource server
                .authorizedGrantTypes("password", "refresh_token");      // grant type
    }


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore)
                .authenticationManager(authenticationManager)
                .userDetailsService(securityUserService);
    }

    @Bean
    public TokenStore tokenStore() {
        //使用内存的tokenStore
        return new InMemoryTokenStore();
    }
}
