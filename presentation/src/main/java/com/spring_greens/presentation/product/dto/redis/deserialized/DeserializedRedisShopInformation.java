package com.spring_greens.presentation.product.dto.redis.deserialized;

import com.spring_greens.presentation.shop.dto.information.ShopInformation;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true)
@Getter
public class DeserializedRedisShopInformation extends ShopInformation<DeserializedRedisProductInformation> { }
