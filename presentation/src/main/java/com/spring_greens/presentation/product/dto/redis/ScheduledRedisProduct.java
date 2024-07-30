package com.spring_greens.presentation.product.dto.redis;

import com.spring_greens.presentation.shop.dto.information.ScheduledRedisShopInformation;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public abstract class ScheduledRedisProduct extends RedisProduct<ScheduledRedisShopInformation>{}
