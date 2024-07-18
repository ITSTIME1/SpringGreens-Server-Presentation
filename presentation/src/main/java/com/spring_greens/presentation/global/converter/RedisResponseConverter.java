package com.spring_greens.presentation.global.converter;

import com.spring_greens.presentation.global.redis.dto.response.MapRedisProductResponse;
import com.spring_greens.presentation.global.redis.entity.RedisProduct;
import com.spring_greens.presentation.global.redis.dto.information.MapProductInformation;
import com.spring_greens.presentation.global.redis.dto.information.MapShopInformation;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * This class is factory class for related to product.
 *
 * @author itsitme0809
 */
@Component
public class RedisResponseConverter<T> {
    // 타입에 따라 다르게 만들어 반환을 해주어야 겠지
    public RedisProduct<?> convertResponse(String domain, RedisProduct<?> response){
        if(domain.equals("map")) {
            // 1. 새로운 데이터를 추출해서 만들어주면 되겠네
            MapProductInformation mapProductInformation = MapProductInformation
                    .builder()
                    .product_name("상품_1")
                    .product_image_url("http://aws.com")
                    .product_view_count(123)
                    .build();

            MapShopInformation mapShopInformation = MapShopInformation
                    .builder()
                    .shop_name("Locks")
                    .shop_contact("024242155")
                    .shop_address_details("2F 우측 3번상가")
                    .product(List.of(mapProductInformation))
                    .build();

            return MapRedisProductResponse
                    .builder()
                    .mall_name("APM")
                    .shop_list(List.of(mapShopInformation))
                    .build();
        }
        return response;
    }
}
