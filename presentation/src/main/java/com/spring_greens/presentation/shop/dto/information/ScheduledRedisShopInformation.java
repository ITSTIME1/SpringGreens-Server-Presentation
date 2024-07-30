package com.spring_greens.presentation.shop.dto.information;

import com.spring_greens.presentation.product.dto.redis.information.ScheduledRedisProductInformation;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true)
@Getter
public class ScheduledRedisShopInformation extends ShopInformation<ScheduledRedisProductInformation>{}
