package com.spring_greens.presentation.global.redis.dto.information;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.spring_greens.presentation.global.redis.deserializer.RedisProductInformationJsonDeserializer;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@JsonDeserialize(using = RedisProductInformationJsonDeserializer.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class ProductInformation {
    private Long product_id;
    private String product_name;
    private Integer product_view_count;
    private String product_image_url;
    private String product_unit;
    private Integer product_price;
    private String major_category;
    private String sub_category;
}