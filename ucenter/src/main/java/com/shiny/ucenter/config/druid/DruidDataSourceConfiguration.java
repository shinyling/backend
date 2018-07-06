package com.shiny.ucenter.config.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.shiny.ucenter.config.security.SecurityOauth2Configuration;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author DELL shiny
 * @create 2018/7/5
 */
@Configuration
@AutoConfigureBefore(SecurityOauth2Configuration.class)
public class DruidDataSourceConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource(){
        DruidDataSource druidDataSource=new DruidDataSource();
        return druidDataSource;
    }
}
