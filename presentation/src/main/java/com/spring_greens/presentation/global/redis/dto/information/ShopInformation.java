package com.spring_greens.presentation.global.redis.dto.information;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Getter
public abstract class ShopInformation <T extends ProductInformation> {
    private Long shop_id;
    private String shop_name;
    private String shop_contact;
    private String shop_address_details;
    private List<T> product;
    public ShopInformation(){}
}

