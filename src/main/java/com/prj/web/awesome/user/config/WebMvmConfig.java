package com.prj.web.awesome.user.config;

import com.prj.web.awesome.user.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvmConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                // 여기다가 로그인 안하면 못들어가는 페이지 경로 쓰면 됩니다..
                .addPathPatterns("/user/myPage/**")
                .addPathPatterns("/user/cart")
                .addPathPatterns("/user/heart")
                .addPathPatterns("/order/orderDetail");



    }
}
