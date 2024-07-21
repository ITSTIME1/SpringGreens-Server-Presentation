package com.spring_greens.presentation.global.redis.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring_greens.presentation.global.exception.CommonException;
import com.spring_greens.presentation.global.redis.converter.ifs.RedisProductResponseConverter;
import com.spring_greens.presentation.global.redis.common.RedisProduct;
import com.spring_greens.presentation.global.redis.deserializer.deserialized.DeserializedRedisProduct;
import com.spring_greens.presentation.global.redis.exception.RedisException;
import com.spring_greens.presentation.global.redis.repository.RedisRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisService {
    private final RedisRepository redisTemplateManager;
    private final RedisProductResponseConverter redisResponseConverter;


    public RedisProduct<?> getProductsFromRedisUsingKey(final String domain, final String mallName)  {
        try {
            RedisProduct<?> redisProductJsonDeserializer = redisTemplateManager
                    .getProductsByMallName(mallName);

            return redisResponseConverter.convertResponse(domain, redisProductJsonDeserializer);
        } catch (NullPointerException e) {
            throw new CommonException.CustomNullPointerException(e.getMessage());
        } catch (JsonProcessingException e) {
            throw new RedisException.RedisJsonProcessingException(e.getMessage());
        }
    }

    public boolean saveProductsToRedis(String mallName, RedisProduct<?> redisProduct) throws JsonProcessingException {
        redisTemplateManager.saveProductsByMallName(mallName, redisProduct);
        return true;
    }

    public void increaseProductViewCount() {
        redisTemplateManager.increaseProductViewCountByShopIdAndProductId();
    }
}
