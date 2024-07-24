package com.spring_greens.presentation.global.redis.dto.request;

import com.spring_greens.presentation.global.redis.dto.information.ProductInformation;
import com.spring_greens.presentation.global.redis.dto.information.ShopInformation;
import com.spring_greens.presentation.global.redis.common.RedisProduct;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
@SuperBuilder
@Getter
public class ScheduledRedisProductRequest extends RedisProduct<ShopInformation<ProductInformation>> {}
