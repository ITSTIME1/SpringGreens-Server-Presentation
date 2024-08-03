package com.spring_greens.presentation.global.config;

import io.micrometer.common.lang.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringConfig {
    @Bean
    public WebMvcConfigurer corsConfigure() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NonNull CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins("http://ec2-3-37-50-217.ap-northeast-2.compute.amazonaws.com")
                        .allowedMethods("GET")
                        .allowedHeaders("*")
                        .allowCredentials(true)
                        .maxAge(3600);

            }
        };
    }
}
