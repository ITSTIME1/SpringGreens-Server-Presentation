package com.spring_greens.presentation.global.redis.dto.information;


import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class ProductInformation {
    private Long product_id;
    private String product_name;
    private int product_view_count;
    private String product_image_url;
    private String product_unit;
    private int product_price;
    private String major_category;
    private String sub_category;
}