package com.spring_greens.presentation.global.redis.entity;
import com.spring_greens.presentation.global.redis.common.RedisProduct;
import com.spring_greens.presentation.global.redis.dto.information.ProductInformation;
import com.spring_greens.presentation.global.redis.dto.information.ShopInformation;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class ScheduledRedisProduct extends RedisProduct<ShopInformation<ProductInformation>> {}
