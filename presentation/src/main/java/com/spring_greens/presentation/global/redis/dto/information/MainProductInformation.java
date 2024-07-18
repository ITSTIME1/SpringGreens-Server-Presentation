package com.spring_greens.presentation.global.redis.dto.information;


import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class MainProductInformation extends ProductInformation {
    private String unit;
    private String major_category;
    private String sub_category;
}
