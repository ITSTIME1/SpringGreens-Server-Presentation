package com.spring_greens.presentation.global.redis.deserializer.deserialized;

import com.spring_greens.presentation.global.redis.common.RedisProduct;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.List;

@SuperBuilder
@Getter
public class DeserializedRedisProduct extends RedisProduct<DeserializedRedisShopInformation>  {
    private Long mall_id;
    private String mall_name;
    private List<DeserializedRedisShopInformation> shop_list;
}
