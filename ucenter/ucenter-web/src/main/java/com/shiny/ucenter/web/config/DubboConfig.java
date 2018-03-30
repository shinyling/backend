package com.shiny.ucenter.web.config;

import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shiny
 **/
@Configuration
@EnableApolloConfig
public class DubboConfig {

    @Value("${spring.dubbo.application.name}")
    private String applicationName;

    @Value("${spring.dubbo.registry.address}")
    private String registryAddress;

    @Value("${spring.dubbo.protocol.name}")
    private String protocolName;

    @Value("${spring.dubbo.protocol.port}")
    private Integer protocolPort;

    @Bean
    public static AnnotationBean annotationBean(@Value("${spring.dubbo.scan}")String scan) {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage(scan);
        return annotationBean;
    }

    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName(protocolName);
        protocolConfig.setPort(protocolPort);
        return protocolConfig;
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(registryAddress);
        return registryConfig;
    }
}
