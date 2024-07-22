package com.spring_greens.presentation.global.redis.deserializer.deserialized;

import com.spring_greens.presentation.global.redis.common.RedisProduct;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.List;

@SuperBuilder
@Getter
public class DeserializedRedisProduct extends RedisProduct<DeserializedRedisShopInformation> {}
