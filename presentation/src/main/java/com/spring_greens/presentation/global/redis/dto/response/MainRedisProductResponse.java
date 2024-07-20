package com.spring_greens.presentation.global.redis.dto.response;

import com.spring_greens.presentation.global.redis.dto.information.MainShopInformation;
import com.spring_greens.presentation.global.redis.common.RedisProduct;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class MainRedisProductResponse extends RedisProduct<MainShopInformation> {}
