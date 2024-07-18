package com.spring_greens.presentation.global.redis.entity;
import com.spring_greens.presentation.global.redis.dto.information.ProductInformation;
import com.spring_greens.presentation.global.redis.dto.information.ShopInformation;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Getter
public abstract class RedisProduct<T extends ShopInformation<? extends ProductInformation>> {
    private Long mall_id;
    private String mall_name;
    private List<T> shop_list;
}







