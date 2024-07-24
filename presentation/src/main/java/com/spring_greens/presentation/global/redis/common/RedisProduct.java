package com.spring_greens.presentation.global.redis.common;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.spring_greens.presentation.global.redis.deserializer.RedisProductJsonDeserializer;
import com.spring_greens.presentation.global.redis.dto.information.ProductInformation;
import com.spring_greens.presentation.global.redis.dto.information.ShopInformation;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * This abstract class root class for MainRedisProductResponse and MapRedisProductResponse and ScheduledRedisProduct and ScheduledRedisProductRequest.<br>
 * basically, JsonDeserialize class is RedisProductJsonDeserializer. <br>
 * JsonInclude automatically will help that remove if filed has null. <br>
 * @author itstime0809
 * @param <T> extends ShopInformation
 */
@SuperBuilder
@Getter
@JsonDeserialize(using = RedisProductJsonDeserializer.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class RedisProduct<T extends ShopInformation<? extends ProductInformation>> {
    private Long mall_id;
    private String mall_name;
    private List<T> shop_list;
}







