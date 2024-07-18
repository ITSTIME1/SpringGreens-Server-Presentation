package com.spring_greens.presentation.global.redis.dto.information;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class MapShopInformation extends ShopInformation<MapProductInformation> {
    private String shop_address_details;

    private String shop_contact;
}