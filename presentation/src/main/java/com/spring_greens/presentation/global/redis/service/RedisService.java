package com.spring_greens.presentation.global.redis.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring_greens.presentation.global.converter.RedisResponseConverter;
import com.spring_greens.presentation.global.redis.manager.RedisTemplateManager;
import com.spring_greens.presentation.global.redis.entity.RedisProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisService {
    private final RedisTemplateManager redisTemplateManager;
    private final RedisResponseConverter<?> redisResponseConverter;

    public RedisProduct<?> getProductsFromRedisUsingKey(final String domain, final String mallName)  {
        try {
            RedisProduct<?> redisProduct = redisTemplateManager
                    .getProductsByMallName(mallName).orElseThrow(() -> new RuntimeException("No products found"));
            return redisResponseConverter.convertResponse(domain, redisProduct);
        } catch (NullPointerException e) {
            throw new RuntimeException("null");
        } catch (JsonProcessingException e) {
            throw new RuntimeException("processing");
        }
    }

    public boolean saveProduct(String mallName, RedisProduct<?> redisProduct) throws JsonProcessingException {
        redisTemplateManager.saveProductByMallName(mallName, redisProduct);
        return true;
    }
}
