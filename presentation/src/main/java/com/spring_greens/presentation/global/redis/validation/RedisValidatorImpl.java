package com.spring_greens.presentation.global.redis.validation;

import com.spring_greens.presentation.global.enums.Domain;
import com.spring_greens.presentation.global.enums.Mall;
import com.spring_greens.presentation.global.redis.dto.request.RedisProductRequest;
import com.spring_greens.presentation.global.redis.validation.ifs.RedisValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
public class RedisValidatorImpl extends RedisValidator {
    @Override
    public boolean validate(RedisProductRequest redisProductRequest) {
        // 1. 모든 값이 널인지 확인한다.
        if(isNull(redisProductRequest.getMallName(), redisProductRequest.getDomain())) {
            throw new IllegalArgumentException();
        }
        // 2. 해당 도메인이 포함되어 있는지 확인한다.
        if(!containsDomain(redisProductRequest.getDomain())) {
            throw new IllegalArgumentException();
        }

        // 3. 건물이 포함되어 있는지 확인한다.
        if(!containsMall(redisProductRequest.getMallName())) {
            throw new IllegalArgumentException();
        }
        // 4. 널이 아니고, 유효한 도메인이면서 건물이름이 포함되어 있으면 유효하다.
        return true;
    }

    @Override
    public boolean isNull(String... parameters) {
        return Arrays.stream(parameters).anyMatch(param -> param == null || param.isEmpty());
    }

    @Override
    public boolean containsDomain(String domain) {
        Domain[] domains = Domain.values();
        return Arrays.stream(domains).anyMatch(param -> param.getDomain().equals(domain));
    }

    @Override
    public boolean containsMall(String mallName) {
        Mall[] malls = Mall.values();
        return Arrays.stream(malls).anyMatch(param -> param.getMallName().equals(mallName));
    }
}
