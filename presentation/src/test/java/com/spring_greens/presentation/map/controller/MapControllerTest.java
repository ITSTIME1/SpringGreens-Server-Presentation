package com.spring_greens.presentation.map.controller;

import com.spring_greens.presentation.global.api.ApiResponse;
import com.spring_greens.presentation.global.redis.dto.response.MapRedisProductResponse;
import com.spring_greens.presentation.global.redis.dto.information.MapProductInformation;
import com.spring_greens.presentation.global.redis.dto.information.MapShopInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class MapControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MapController mapController;

    private MapRedisProductResponse mapProductResponse;
    private MapShopInformation mapShopInformation;

    private MapProductInformation mapProductInformation;

    private String mallName;
    private String domain;
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

        mallName = "APM";
        domain = "map";
    }

    /**
     * Return ProductResponse that contains JSON product information.
     * @throws Exception
     */
    @Test
    @DisplayName("지도 상품 요청 성공 케이스")
    public void 지도상품요청_성공() throws Exception {
        // given
        // custom response stub object
        ApiResponse<MapRedisProductResponse> successProductApiResponse = ApiResponse.ok(mapProductResponse);

        // when
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/main/get/products/{mall_name}", mallName)
                        .accept(MediaType.APPLICATION_JSON));


        // then
        resultActions.andExpect(status().isOk()).andDo(print());
    }


    @Test
    @DisplayName("지도 상품 요청 실패 케이스")
    public void 지도상품요청_실패() throws Exception {
        // given
        // custom response stub object
        ApiResponse<MapRedisProductResponse> failProductApiResponse = ApiResponse.fail(mapProductResponse);
        

        // when
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/main/test")
                        .accept(MediaType.APPLICATION_JSON));

        // then
        resultActions.andExpect(status().is4xxClientError());
    }

}