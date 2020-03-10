package com.neoniou.blog.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Neo.Zzj
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration authInterceptor = registry.addInterceptor(new AuthInterceptor());
        authInterceptor.addPathPatterns("/blog/auth/**");

        InterceptorRegistration tokenInterceptor = registry.addInterceptor(new TokenInterceptor());
        tokenInterceptor.addPathPatterns("/**");
    }
}
