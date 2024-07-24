package com.spring_greens.presentation.global.redis.deserializer.deserialized;

import com.spring_greens.presentation.global.redis.dto.information.ShopInformation;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class DeserializedRedisShopInformation extends ShopInformation<DeserializedRedisProductInformation> { }
