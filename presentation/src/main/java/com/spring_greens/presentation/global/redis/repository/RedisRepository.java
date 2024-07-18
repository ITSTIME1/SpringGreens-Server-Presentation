package com.spring_greens.presentation.global.redis.repository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring_greens.presentation.global.redis.entity.RedisProduct;

import java.util.Optional;

public interface RedisRepository {
    Optional<? extends RedisProduct<?>> getProductsByMallName(final String mallName) throws JsonProcessingException;
//    boolean incrementViewCount();

    boolean saveProductByMallName(final String mallName, final RedisProduct<?> redisProductRequest) throws JsonProcessingException;
}
