package com.spring_greens.presentation.global.redis.dto.information;

import com.spring_greens.presentation.global.redis.deserializer.deserialized.DeserializedRedisProductInformation;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class MapShopInformation extends ShopInformation<MapProductInformation> {
}
