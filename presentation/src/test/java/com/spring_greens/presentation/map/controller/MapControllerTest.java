package com.spring_greens.presentation.map.controller;

import com.spring_greens.presentation.product.dto.redis.RedisProduct;
import com.spring_greens.presentation.product.dto.redis.response.MapRedisProductResponse;
import com.spring_greens.presentation.global.redis.service.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MapController.class) // Ensure this points to the actual controller class
class MapControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RedisService redisService;

    @Test
    public void 상품요청() throws Exception {
        // given
        final String endPoint = "/api/map/get/products/{domain}/{mall_name}";
        final String domain = "map";
        final String mallName = "APM";

        RedisProduct<?> expectedResponse = MapRedisProductResponse.builder().mall_name("APM").build();
        // when
//        doReturn(expectedResponse).when(redisService).getProductsFromRedisUsingKey(domain, mallName);

        // then
        mockMvc.perform(MockMvcRequestBuilders.get(endPoint, domain, mallName))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.mall_name").value(mallName));
    }
}