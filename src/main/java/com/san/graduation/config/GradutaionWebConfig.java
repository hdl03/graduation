package com.san.graduation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by huangdongliang on 2017/4/11.
 *
 * 解决跨域访问的问题
 */
@Configuration
public class GradutaionWebConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
    	// http://spring.io/guides/gs/rest-service-cors/
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");// TODO
            }
        };
    }
}
