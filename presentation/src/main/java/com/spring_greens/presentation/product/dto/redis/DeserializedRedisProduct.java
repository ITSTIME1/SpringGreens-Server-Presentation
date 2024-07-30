package com.spring_greens.presentation.product.dto.redis;

import com.spring_greens.presentation.product.dto.redis.deserialized.DeserializedRedisShopInformation;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true)
@Getter
public class DeserializedRedisProduct extends RedisProduct<DeserializedRedisShopInformation> {}
