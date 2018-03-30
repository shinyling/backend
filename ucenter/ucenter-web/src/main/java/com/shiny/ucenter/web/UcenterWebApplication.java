package com.shiny.ucenter.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author shiny
 **/
@SpringBootApplication
@EnableCaching
public class UcenterWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(UcenterWebApplication.class,args);
    }
}
