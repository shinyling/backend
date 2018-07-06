package com.shiny.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author DELL shiny
 * @create 2018/7/6
 */
@SpringBootApplication
@ComponentScan("com.shiny.authentication")
public class AuthenticationApp {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticationApp.class,args);
    }
}
