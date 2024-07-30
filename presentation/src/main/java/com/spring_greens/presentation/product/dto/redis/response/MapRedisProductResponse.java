package com.spring_greens.presentation.product.dto.redis.response;

import com.spring_greens.presentation.product.dto.redis.RedisProduct;
import com.spring_greens.presentation.shop.dto.information.MapRedisShopInformation;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class MapRedisProductResponse extends RedisProduct<MapRedisShopInformation> implements RedisProductResponse{}