package com.spring_greens.presentation.product.converter;

import com.fasterxml.jackson.databind.JsonNode;
import com.spring_greens.presentation.global.enums.Domain;
import com.spring_greens.presentation.product.converter.ifs.RedisConverter;
import com.spring_greens.presentation.product.dto.redis.DeserializedRedisProduct;
import com.spring_greens.presentation.product.dto.redis.deserialized.DeserializedRedisProductInformation;
import com.spring_greens.presentation.product.dto.redis.deserialized.DeserializedRedisShopInformation;
import com.spring_greens.presentation.product.dto.redis.information.MapRedisProductInformation;
import com.spring_greens.presentation.product.dto.redis.response.MapRedisProductResponse;
import com.spring_greens.presentation.product.dto.redis.response.RedisProductResponse;
import com.spring_greens.presentation.shop.dto.information.MapRedisShopInformation;
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
public class RedisProductConverterImpl implements RedisConverter {

    private MapRedisProductResponse convertMapRedisProductResponse(DeserializedRedisProduct deserializedRedisProduct) {
        List<MapRedisShopInformation> mapRedisShopInformationList =
                deserializedRedisProduct.getShop_list().stream().map(shopInfo ->
                        MapRedisShopInformation.builder()
                                .shop_name(shopInfo.getShop_name())
                                .shop_contact(shopInfo.getShop_contact())
                                .shop_address_details(shopInfo.getShop_address_details())
                                .product(shopInfo.getProduct().stream().map(productInfo ->
                                                MapRedisProductInformation.builder()
                                                        .product_name(productInfo.getProduct_name())
                                                        .product_view_count(productInfo.getProduct_view_count())
                                                        .product_image_url(productInfo.getProduct_image_url())
                                                        .build())
                                        .collect(Collectors.toList()))
                                .build()).collect(Collectors.toList());
        return MapRedisProductResponse.builder()
                .mall_name(deserializedRedisProduct.getMall_name())
                .shop_list(mapRedisShopInformationList).build();
    }

    @Override
    public DeserializedRedisProduct convertDeserializedRedisProduct(JsonNode jsonNode,
                                                                    List<DeserializedRedisShopInformation> deserializedRedisShopInformationList) {
        return DeserializedRedisProduct.builder()
                .mall_id(jsonNode.get("mall_id").asLong())
                .mall_name(jsonNode.get("mall_name").asText())
                .shop_list(deserializedRedisShopInformationList)
                .build();
    }

    @Override
    public DeserializedRedisShopInformation convertDeserializedRedisShopInformation(JsonNode jsonNode, List<DeserializedRedisProductInformation> deserializedRedisProductInformationList) {
        return DeserializedRedisShopInformation
                .builder()
                .shop_id(jsonNode.get("shop_id").asLong())
                .shop_name(jsonNode.get("shop_name").asText())
                .shop_contact(jsonNode.get("shop_contact").asText())
                .shop_address_details(jsonNode.get("shop_address_details").asText())
                .product(deserializedRedisProductInformationList)
                .build();
    }

    @Override
    public DeserializedRedisProductInformation convertDeserializedRedisProductInformation(JsonNode jsonNode){
        return DeserializedRedisProductInformation
                .builder()
                .product_id(jsonNode.get("product_id").asLong())
                .product_name(jsonNode.get("product_name").asText())
                .product_price(jsonNode.get("product_price").asInt())
                .product_unit(jsonNode.get("product_unit").asText())
                .product_image_url(jsonNode.get("product_image_url").asText())
                .product_view_count(jsonNode.get("product_view_count").asInt())
                .major_category(jsonNode.get("major_category").asText())
                .sub_category(jsonNode.get("sub_category").asText())
                .build();
    }

    @Override
    public RedisProductResponse createResponse(String domain, DeserializedRedisProduct deserializedRedisProduct) {
        if(domain.equals(Domain.MAP.getDomain())) {
            return this.convertMapRedisProductResponse(deserializedRedisProduct);
        }
        return null;
    }
}
