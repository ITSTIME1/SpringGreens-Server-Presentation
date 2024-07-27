package com.spring_greens.presentation.product.dto.redis.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class RedisProductRequest {
    private String domain;
    private String mallName;
}
