//package com.spring_greens.presentation.global.redis.manager;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.spring_greens.presentation.global.redis.dto.deserialize.RedisProductJsonDeserializer;
//import com.spring_greens.presentation.global.redis.dto.information.MapProductInformation;
//import com.spring_greens.presentation.global.redis.dto.information.MapShopInformation;
//import com.spring_greens.presentation.global.redis.dto.information.ProductInformation;
//import com.spring_greens.presentation.global.redis.dto.information.ShopInformation;
//import com.spring_greens.presentation.global.redis.dto.request.ScheduledRedisProductRequest;
//import com.spring_greens.presentation.global.redis.dto.response.MapRedisProductResponse;
//import com.spring_greens.presentation.global.redis.common.RedisProduct;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.*;
//
//
//@ExtendWith(MockitoExtension.class)
//class RedisTemplateManagerTest {
//
//    @Mock
//    private RedisTemplate<String, Object> redisJsonTemplate;
//
//    @Mock
//    private ObjectMapper objectMapper;
//
//    @InjectMocks
//    private RedisTemplateManager redisTemplateManager;
//
//    private ScheduledRedisProductRequest scheduledRedisProductRequest;
//
//    private String serializedString;
//
//    @BeforeEach
//    public void setup() throws JsonProcessingException {
//        ValueOperations<String, Object> valueOps = mock(ValueOperations.class); // DefaultValueOperation inject
//        when(redisJsonTemplate.opsForValue()).thenReturn(valueOps);
//
//        scheduledRedisProductRequest = ScheduledRedisProductRequest.builder()
//                .mall_id(12L)
//                .mall_name("APM")
//                .shop_list(Collections.singletonList(
//                        ShopInformation.builder()
//                                .shop_id(123L)
//                                .shop_name("상점이름")
//                                .shop_contact("02-424-2155")
//                                .shop_address_details("2F 우측 3번")
//                                .product(Collections.singletonList(ProductInformation.builder()
//                                        .product_id(12L)
//                                        .product_name("밴딩 슬랙스")
//                                        .product_unit("개 or 고미")
//                                        .product_price(123456)
//                                        .product_image_url("http://aws-ec2-public-ipv4:port/mnt/data/APM/product/images/product_1.jpg")
//                                        .major_category("상의")
//                                        .sub_category("셔츠")
//                                        .build()))
//                                .build()))
//                .build();
//
//
//        serializedString = objectMapper.writeValueAsString(scheduledRedisProductRequest);
//    }
//
//    @Test
//    @DisplayName("상가 데이터 레디스에 적재")
//    public void 레디스데이터_적재_성공() throws JsonProcessingException {
//        // given
//        String mallName = "APM";
//        ScheduledRedisProductRequest scheduledRedisProductRequest = ScheduledRedisProductRequest.builder()
//                .mall_id(12L)
//                .mall_name("APM")
//                .shop_list(Collections.singletonList(
//                        ShopInformation.builder()
//                                .shop_id(123L)
//                                .shop_name("상점이름")
//                                .shop_contact("02-424-2155")
//                                .shop_address_details("2F 우측 3번")
//                                .product(Collections.singletonList(ProductInformation.builder()
//                                        .product_id(12L)
//                                        .product_name("밴딩 슬랙스")
//                                        .product_unit("개 or 고미")
//                                        .product_price(123456)
//                                        .product_image_url("http://aws-ec2-public-ipv4:port/mnt/data/APM/product/images/product_1.jpg")
//                                        .major_category("상의")
//                                        .sub_category("셔츠")
//                                        .build()))
//                                .build()))
//                .build();
//
//        String serializedString = objectMapper.writeValueAsString(scheduledRedisProductRequest);
//
//        // when
//        when(objectMapper.writeValueAsString(scheduledRedisProductRequest)).thenReturn(serializedString);
//
//        // when
//        redisTemplateManager.saveProductsByMallName(mallName, scheduledRedisProductRequest);
//
//        // then
//        verify(redisJsonTemplate.opsForValue(), times(1)).setIfAbsent(mallName, serializedString);
//    }
//
//
//    @Test
//    @DisplayName("상가 데이터 레디스에서 가지고 오기")
//    public void 레디스데이터_추출() throws JsonProcessingException {
//
//        // given
//        final String mallName = "APM";
//
//        MapProductInformation mapProductInformation = MapProductInformation
//                .builder()
//                .product_name("상품_1")
//                .product_image_url("http://aws.com")
//                .product_view_count(123)
//                .build();
//
//        MapShopInformation mapShopInformation = MapShopInformation
//                .builder()
//                .shop_name("Locks")
//                .shop_contact("024242155")
//                .shop_address_details("2F 우측 3번상가")
//                .product(List.of(mapProductInformation))
//                .build();
//
//        MapRedisProductResponse mapProductResponse = MapRedisProductResponse
//                .builder()
//                .mall_name("APM")
//                .shop_list(List.of(mapShopInformation))
//                .build();
//
//        when(redisJsonTemplate.opsForValue().get(mallName)).thenReturn(serializedString);
//        // when
//        RedisProductJsonDeserializer result =  redisTemplateManager.getProductsByMallName(mallName);
//
//        // then
//        verify(redisJsonTemplate.opsForValue(), times(1)).get(mallName);
//    }
//}