package com.secondhand.springboot.config;


import com.secondhand.springboot.Inteceptor.LoginInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class Configurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration=registry.addInterceptor(new LoginInterceptor());
        registration.addPathPatterns("/**");//默认拦截所有，你们需要的时候改
        registration.excludePathPatterns("/","/login","/error","/static/**","/logout");// 默认不拦截路径 需要就改
    }
}
