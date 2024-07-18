package com.spring_greens.presentation.global.redis.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring_greens.presentation.global.converter.RedisResponseConverter;
import com.spring_greens.presentation.global.redis.dto.information.MapProductInformation;
import com.spring_greens.presentation.global.redis.dto.information.MapShopInformation;
import com.spring_greens.presentation.global.redis.dto.request.ScheduledRedisProductRequest;
import com.spring_greens.presentation.global.redis.dto.response.MapRedisProductResponse;
import com.spring_greens.presentation.global.redis.entity.RedisProduct;
import com.spring_greens.presentation.global.redis.entity.ScheduledRedisProduct;
import com.spring_greens.presentation.global.redis.manager.RedisTemplateManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RedisServiceTest {

    @Mock
    private RedisTemplateManager redisTemplateManager;
    @Mock
    private RedisResponseConverter<?> redisResponseConverter;
    @InjectMocks
    private RedisService redisService;

    private MapRedisProductResponse mapProductResponse;
    private MapShopInformation mapShopInformation;

    private MapProductInformation mapProductInformation;

    @BeforeEach
    public void 초기화() {
        mapProductInformation = MapProductInformation
                .builder()
                .product_name("상품_1")
                .product_image_url("http://aws.com")
                .product_view_count(123)
                .build();

        mapShopInformation = MapShopInformation
                .builder()
                .shop_name("Locks")
                .shop_contact("024242155")
                .shop_address_details("2F 우측 3번상가")
                .product(List.of(mapProductInformation))
                .build();

        mapProductResponse = MapRedisProductResponse
                .builder()
                .mall_name("APM")
                .shop_list(List.of(mapShopInformation))
                .build();
    }

    @Test
    @DisplayName("상품 추출 테스트")
    public void 상품추출하기() throws JsonProcessingException {
        // given
        String mallName = "APM";
        String domain = "map";

        given(redisTemplateManager.getProductsByMallName(mallName)).willAnswer(invocationOnMock -> Optional.of(mapProductResponse));
        given(redisResponseConverter.convertResponse(eq(domain), any(RedisProduct.class))).willAnswer(invocationOnMock -> mapProductResponse);


        // when
        RedisProduct<?> redisProduct = redisService.getProductsFromRedisUsingKey(domain, mallName);

        verify(redisTemplateManager, times(1)).getProductsByMallName(mallName);
        verify(redisResponseConverter, times(1)).convertResponse(eq(domain), any(RedisProduct.class));
        assertThat(mapProductResponse.getMall_name()).isEqualTo(redisProduct.getMall_name());
    }

    @Test
    @DisplayName("상품 저장 테스트")
    public void 상품저장() throws JsonProcessingException {
        // given

        String mallName = "APM";
        String domain = "map";
        ScheduledRedisProductRequest expectedProductRequest = ScheduledRedisProductRequest.builder().mall_name(mallName).build();
        given(redisTemplateManager.saveProductByMallName(eq(mallName), any(ScheduledRedisProductRequest.class))).willReturn(true);

        // when
        boolean result = redisService.saveProduct(mallName, expectedProductRequest);
        verify(redisTemplateManager, times(1)).saveProductByMallName(eq(mallName), any(ScheduledRedisProductRequest.class));
        assertThat(result).isTrue();
    }

}