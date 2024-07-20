package com.spring_greens.presentation.global.redis.repository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring_greens.presentation.global.redis.common.RedisProduct;
import com.spring_greens.presentation.global.redis.dto.deserialize.RedisProductJsonDeserializer;

public interface RedisRepository {
    RedisProductJsonDeserializer getProductsByMallName(final String mallName) throws JsonProcessingException;

    boolean saveProductsByMallName(final String mallName, final RedisProduct<?> redisProductRequest) throws JsonProcessingException;

    void increaseProductViewCountByShopIdAndProductId();
}
