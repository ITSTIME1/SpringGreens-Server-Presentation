package com.spring_greens.presentation.global.redis.validation;

import com.spring_greens.presentation.global.enums.Domain;
import com.spring_greens.presentation.global.enums.Mall;
import com.spring_greens.presentation.global.redis.validation.ifs.RedisValidator;
import com.spring_greens.presentation.product.dto.redis.request.RedisProductRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
public class RedisValidatorImpl extends RedisValidator {
    @Override
    public boolean validate(RedisProductRequest redisProductRequest) {
        // 1. Check null parameter.
        if(isNull(redisProductRequest.getMallName(), redisProductRequest.getDomain())) {
            throw new NullPointerException("All argument is null");
        }
        // 2. Check correct domain parameter.
        if(!containsDomain(redisProductRequest.getDomain())) {
            throw new IllegalArgumentException("Domain argument is illegal");
        }
        // 3. Check correct mallName parameter.
        if(!containsMall(redisProductRequest.getMallName())) {
            throw new IllegalArgumentException("MallName argument is illegal");
        }
        // 4. Return true if validate is alright.
        return true;
    }

    @Override
    protected boolean isNull(String... parameters) {
        return Arrays.stream(parameters).anyMatch(param -> param == null || param.isEmpty());
    }

    @Override
    protected boolean containsDomain(String domain) {
        Domain[] domains = Domain.values();
        return Arrays.stream(domains).anyMatch(param -> param.getDomain().equals(domain));
    }

    @Override
    protected boolean containsMall(String mallName) {
        Mall[] malls = Mall.values();
        return Arrays.stream(malls).anyMatch(param -> param.getMallName().equals(mallName));
    }
}
