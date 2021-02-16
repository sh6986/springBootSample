package com.example.bootsample.common.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    // 필터 클래스를 Bean으로 등록하기 위해 FilterRegistrationBean을 사용한다.
    public FilterRegistrationBean getFilterRegistrationBean() {

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new CommonFilter());

        return filterRegistrationBean;
    }


}
