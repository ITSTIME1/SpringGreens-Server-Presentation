package com.spring_greens.presentation.global.redis.converter;

import com.spring_greens.presentation.global.enums.Domain;
import com.spring_greens.presentation.global.redis.converter.ifs.RedisProductResponseConverter;
import com.spring_greens.presentation.global.redis.deserializer.deserialized.DeserializedRedisProductInformation;
import com.spring_greens.presentation.global.redis.deserializer.deserialized.DeserializedRedisShopInformation;
import com.spring_greens.presentation.global.redis.dto.information.MapProductInformation;
import com.spring_greens.presentation.global.redis.dto.information.MapShopInformation;
import com.spring_greens.presentation.global.redis.dto.response.MapRedisProductResponse;
import com.spring_greens.presentation.global.redis.common.RedisProduct;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Implementation of RedisProductResponseConverter. <br>
 * this performs convert method and return RedisProduct type. <br>
 *
 * @author itsitme0809
 */
@Component
public class RedisProductResponseConverterImpl implements RedisProductResponseConverter {
    @Override
    public RedisProduct<?> convertResponse(String domain, RedisProduct<?> response){
        if(domain.equals(Domain.MAP.getDomain())) {
            List<MapShopInformation> mapShopInformationList = response.getShop_list().stream()
                    .map(shopInfo -> MapShopInformation.builder()
                            .shop_name(shopInfo.getShop_name())
                            .shop_contact(shopInfo.getShop_contact())
                            .shop_address_details(shopInfo.getShop_address_details())
                            .product(shopInfo.getProduct().stream().map(
                                    productInfo -> MapProductInformation.builder()
                                            .product_name(productInfo.getProduct_name())
                                            .product_view_count(productInfo.getProduct_view_count())
                                            .product_image_url(productInfo.getProduct_image_url())
                                            .build()).collect(Collectors.toList()))
                            .build()).collect(Collectors.toList());


            return MapRedisProductResponse.builder()
                    .mall_name(response.getMall_name())
                    .shop_list(mapShopInformationList)
                    .build();
        }
        return null;
    }
}
