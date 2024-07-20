package com.spring_greens.presentation.global.redis.common;
import com.spring_greens.presentation.global.redis.dto.information.ProductInformation;
import com.spring_greens.presentation.global.redis.dto.information.ShopInformation;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * This abstract class root class for MainRedisProductResponse and MapRedisProductResponse and ScheduledRedisProduct and ScheduledRedisProductRequest.<br>
 *
 * @param <T>
 */
@SuperBuilder
@Getter
public abstract class RedisProduct<T extends ShopInformation<? extends ProductInformation>> {
    private Long mall_id;
    private String mall_name;
    private List<T> shop_list;
    public RedisProduct(){}
}







