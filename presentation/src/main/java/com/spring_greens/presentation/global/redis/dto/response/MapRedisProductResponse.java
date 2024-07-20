package com.spring_greens.presentation.global.redis.dto.response;
import com.spring_greens.presentation.global.redis.dto.information.MapShopInformation;
import com.spring_greens.presentation.global.redis.common.RedisProduct;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class MapRedisProductResponse extends RedisProduct<MapShopInformation> {
}