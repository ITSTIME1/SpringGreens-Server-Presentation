package com.spring_greens.presentation.global.redis.dto.request;

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
