package com.spring_greens.presentation.map.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring_greens.presentation.global.api.ApiResponse;
import com.spring_greens.presentation.global.controller.AbstractBaseController;
import com.spring_greens.presentation.global.redis.entity.ScheduledRedisProduct;
import com.spring_greens.presentation.global.redis.dto.response.MainRedisProductResponse;
import com.spring_greens.presentation.global.redis.entity.RedisProduct;
import com.spring_greens.presentation.global.redis.dto.information.ProductInformation;
import com.spring_greens.presentation.global.redis.dto.information.ShopInformation;
import com.spring_greens.presentation.global.redis.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/map")
public class MapController extends AbstractBaseController {
    private final RedisService redisService;
    @Override
    protected ApiResponse<MainRedisProductResponse> handleGetProductsOfMall(String domain, String mallName) {
        // 1. 상품을 찾는 요청을 서비스 레이어에 요청한다. 예외를 잡아 주어야 함.

        RedisProduct<?> redisProduct = redisService.getProductsFromRedisUsingKey(domain, mallName);


        return ApiResponse.ok(null);
    }

    @PostMapping("/test/redis/create")
    public void test () throws JsonProcessingException {
        String mallName = "APM";
        ScheduledRedisProduct redisProduct = ScheduledRedisProduct.builder()
                .mall_id(12L)
                .mall_name("APM")
                .shop_list(Arrays.asList(
                        ShopInformation.builder()
                                .shop_id(123L)
                                .shop_name("상점이름")
                                .shop_contact("02-424-2155")
                                .shop_address_details("2F 우측 3번")
                                .product(Arrays.asList(ProductInformation.builder()
                                        .product_id(12L)
                                        .product_name("밴딩 슬랙스")
                                        .product_unit("개 or 고미")
                                        .product_price(123456)
                                        .product_image_url("http://aws-ec2-public-ipv4:port/mnt/data/APM/product/images/product_1.jpg")
                                        .major_category("상의")
                                        .sub_category("셔츠")
                                        .build()))
                                .build()))
                .build();
        redisService.saveProduct(mallName, redisProduct);
    }
}
