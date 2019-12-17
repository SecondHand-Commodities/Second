package com.secondhand.springboot.config;


import com.secondhand.springboot.Inteceptor.LimitInteceptor;
import com.secondhand.springboot.Inteceptor.LoginInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Configurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加登录拦截器
        InterceptorRegistration registration=registry.addInterceptor(new LoginInterceptor());
        registration.addPathPatterns("/**");//默认拦截所有，你们需要的时候改
        registration.excludePathPatterns("/","/login","/error","/static/**","/logout");// 默认不拦截路径 需要就改

        //添加权限拦截器
        InterceptorRegistration registration1 = registry.addInterceptor(new LimitInteceptor());
        registration1.addPathPatterns("/login");
        registration1.excludePathPatterns("/","/login","/error","/static/**","/logout");// 默认不拦截路径 需要就改
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	// TODO Auto-generated method stub
    	
    	registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");
    	WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}
