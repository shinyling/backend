package com.shiny.ucenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * 主启动类
 *
 * @author DELL shiny
 * @create 2018/7/5
 */
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.shiny.ucenter.dao")
public class UcenterApplication {

    public static void main(String[] args) {

        SpringApplication.run(UcenterApplication.class,args);

    }

}
