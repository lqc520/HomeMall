package cn.lqcnb.mall.api.config;

import cn.lqcnb.mall.api.interceptor.AdminAuthenticationInterceptor;
import cn.lqcnb.mall.api.interceptor.AdminLoginInterceptor;
import cn.lqcnb.mall.api.interceptor.AliPayInterceptor;
import cn.lqcnb.mall.api.interceptor.AuthenticationInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.List;

@SpringBootConfiguration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/**");
        registry.addInterceptor(adminAuthenticationInterceptor())
                .addPathPatterns("/**");
        registry.addInterceptor(new AdminLoginInterceptor()).addPathPatterns("/views/index.html")
                .excludePathPatterns("/css/**", "/img/**", "/js/**", "/plugin/**", "/fonts/**");
        registry.addInterceptor(new AliPayInterceptor()).addPathPatterns("/api/alipay/**");
    }



    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }

    @Bean
    public AdminAuthenticationInterceptor adminAuthenticationInterceptor() {
        return new AdminAuthenticationInterceptor();
    }

}
