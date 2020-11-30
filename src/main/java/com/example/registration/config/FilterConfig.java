package com.example.registration.config;


import com.example.registration.filter.AuthHeaderSettingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: registration
 * @description: 过滤器配置类
 * @author: meihua
 * @created: 2020/11/30 17:50
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean modifyParametersFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new AuthHeaderSettingFilter());
        registration.addUrlPatterns("/*");
        registration.setName("authHeaderSettingFilter");
        registration.setOrder(1);
        return registration;
    }
}
