package com.example.bootsample.common.config;

import com.example.bootsample.common.filter.CommonFilter;
import com.example.bootsample.common.filter.SampleSiteMeshFilter;
import com.example.bootsample.common.interceptor.CommonInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    // 필터 클래스를 Bean으로 등록하기 위해 FilterRegistrationBean을 사용한다.
    public FilterRegistrationBean getFilterRegistrationBean() {

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new CommonFilter());

        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean siteMeshFilter() {
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(new SampleSiteMeshFilter());
        return filter;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CommonInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/")
                .excludePathPatterns("/asserts/**")
                .excludePathPatterns("/view/member/login")
                .excludePathPatterns("/view/member/join")
                .excludePathPatterns("/member/login")
                .excludePathPatterns("/member/reg")
                .excludePathPatterns("/member/**");
    }
}
