package com.spring_greens.presentation.global.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.spring_greens.presentation.global.redis.deserializer.RedisProductJsonDeserializer;
import com.spring_greens.presentation.global.redis.deserializer.deserialized.DeserializedRedisProduct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class SpringConfig {
//    @Bean
//    public ObjectMapper objectMapper () {
//        return new ObjectMapper();
//    }
}
