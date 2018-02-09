package com.aishang.asjf.assembly.config.dubbo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.springframework.context.annotation.Bean;

//@Configuration
public class DubboConfig {


    public static final String APPLICATION_NAME = "provider-of-app";

    public static final String REGISTRY_ADDRESS = "redis://192.168.1.194:6379";

    public static final String ANNOTATION_PACKAGE = "com.aishang.app.adapter";

    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(APPLICATION_NAME);
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(REGISTRY_ADDRESS);
        return registryConfig;
    }
}
