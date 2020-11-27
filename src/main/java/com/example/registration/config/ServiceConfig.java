package com.example.registration.config;

import com.example.registration.listener.ServiceListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: registration
 * @description:
 * @author: meihua
 * @created: 2020/11/27 11:23
 */
@Configuration
public class ServiceConfig {


    @Bean(initMethod = "init", destroyMethod = "destroy")
    public ServiceListener  ServiceListener(){
        ServiceListener serviceListener=new ServiceListener();

        return serviceListener;
    }

}
