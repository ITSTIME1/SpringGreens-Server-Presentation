package com.spring_greens.presentation.global.redis.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring_greens.presentation.global.exception.CommonException;
import com.spring_greens.presentation.global.redis.converter.ifs.RedisProductResponseConverter;
import com.spring_greens.presentation.global.redis.common.RedisProduct;
import com.spring_greens.presentation.global.redis.dto.request.RedisProductRequest;
import com.spring_greens.presentation.global.redis.exception.RedisException;
import com.spring_greens.presentation.global.redis.repository.RedisRepository;
import com.spring_greens.presentation.global.redis.validation.ifs.RedisValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisService {
    private final RedisRepository redisTemplateManager;
    private final RedisProductResponseConverter redisResponseConverter;
    private final RedisValidator redisValidator;


    public RedisProduct<?> getProductsFromRedisUsingKey(RedisProductRequest redisProductRequest)  {
        try {
            RedisProduct<?> redisProductJsonDeserializer = null;
            // 1. 파라미터 검증
            if(validateRedisProductRequestParameter(redisProductRequest)) {
                // 2. 상품 가져오기
                redisProductJsonDeserializer = redisTemplateManager
                        .getProductsByMallName(redisProductRequest.getMallName());
            };
            // 3. 상품 반환
            return redisResponseConverter.convertResponse(redisProductRequest.getDomain(), redisProductJsonDeserializer);

        } catch (NullPointerException e) {
            throw new CommonException.CustomNullPointerException(e.getMessage());
        } catch (JsonProcessingException e) {
            throw new RedisException.RedisJsonProcessingException(e.getMessage());
        } catch (IllegalArgumentException e) {
            throw new RedisException.RedisIllegalArgumentException(e.getMessage());
        }
    }
    public boolean validateRedisProductRequestParameter(RedisProductRequest redisProductRequest) throws IllegalArgumentException{
        return redisValidator.validate(redisProductRequest);
    }
}
