package com.spring_greens.presentation.global.redis.dto.information;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.spring_greens.presentation.global.redis.deserializer.RedisShopInformationJsonDeserializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Getter
@JsonDeserialize(using = RedisShopInformationJsonDeserializer.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class ShopInformation <T extends ProductInformation> {
    private Long shop_id;
    private String shop_name;
    private String shop_contact;
    private String shop_address_details;
    private List<T> product;
}

