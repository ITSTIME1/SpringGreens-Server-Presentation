package com.spring_greens.presentation.global.redis.manager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.spring_greens.presentation.global.redis.dto.response.MapRedisProductResponse;
import com.spring_greens.presentation.global.redis.repository.RedisRepository;
import com.spring_greens.presentation.global.redis.entity.RedisProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RedisTemplateManager implements RedisRepository {

    private final RedisTemplate<String, Object> redisJsonTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public Optional<? extends RedisProduct<?>> getProductsByMallName(final String mallName) throws JsonProcessingException, NullPointerException {
        Object objectData = redisJsonTemplate.opsForValue().get(mallName);

        if(objectData == null) {
            return Optional.empty();
        }

        RedisProduct<?> redisProduct = objectMapper.readValue(objectData.toString(), MapRedisProductResponse.class);
        return Optional.ofNullable(redisProduct);
    }

    @Override
    public boolean saveProductByMallName(String mallName, RedisProduct<?> redisProductRequest) throws JsonProcessingException, NullPointerException {
        String serializedString = objectMapper.writeValueAsString(redisProductRequest);
        redisJsonTemplate.opsForValue().set(mallName, serializedString);
        return true;
    }
}
