package com.spring_greens.presentation.global.redis.manager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring_greens.presentation.global.redis.deserializer.deserialized.DeserializedRedisProduct;
import com.spring_greens.presentation.global.redis.dto.information.ProductInformation;
import com.spring_greens.presentation.global.redis.repository.RedisRepository;
import com.spring_greens.presentation.global.redis.common.RedisProduct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * TemplateManager contains RedisTemplate for Json, Hash. <br>
 * this class performs CRUD for Redis Server. <br>
 * the main feature of this class is that it transfers all exceptions to the Service Layer. <br>
 * @author itstime0809
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class RedisTemplateManager implements RedisRepository {

    private final RedisTemplate<String, Object> redisJsonTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public RedisProduct<?> getProductsByMallName(final String mallName) throws JsonProcessingException {
        final Object serializedProducts = redisJsonTemplate.opsForValue().get(mallName);
        if(serializedProducts == null) {
            throw new NullPointerException();
        }
        return objectMapper.readValue(serializedProducts.toString(), RedisProduct.class);
    }

    @Override
    public boolean saveProductsByMallName(String mallName, RedisProduct<?> redisProductRequest) throws JsonProcessingException {
        final String serializedString = objectMapper.writeValueAsString(redisProductRequest);
        redisJsonTemplate.opsForValue().setIfPresent(mallName, serializedString);
        return true;
    }

    @Override
    public void increaseProductViewCountByShopIdAndProductId() {}
}
