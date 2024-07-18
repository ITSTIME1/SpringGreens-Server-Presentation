//package com.spring_greens.presentation.main.controller;
//
//import com.spring_greens.presentation.global.api.ApiResponse;
//import com.spring_greens.presentation.product.dto.response.MainProductResponse;
//import com.spring_greens.presentation.product.dto.response.information.MainProductInformation;
//import com.spring_greens.presentation.product.dto.response.information.MainShopInformation;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@WebMvcTest
//class MainControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private MainController mainController;
//
//    private MainProductResponse mainProductResponse;
//    private MainShopInformation mainShopInformation;
//    private MainProductInformation mainProductInformation;
//
//    @BeforeEach
//    public void 초기화() {
//        mainProductInformation = MainProductInformation
//                .builder()
//                .product_name("밴딩 슬랙스")
//                .major_category("상의")
//                .sub_category("셔츠")
//                .unit("개")
//                .product_image_url("http://aws-ec2-public-ipv4:port/mnt/data/APM/product/images/product_1.jpg")
//                .product_view_count(12)
//                .build();
//
//        mainShopInformation = MainShopInformation
//                .builder()
//                .shop_id(1L)
//                .shop_name("Lack")
//                .product(List.of(mainProductInformation))
//                .build();
//
//        mainProductResponse = MainProductResponse
//                .builder()
//                .mall_id(1L)
//                .mall_name("APM")
//                .shop_list(List.of(mainShopInformation))
//                .build();
//    }
//
//    /**
//     * Return ProductResponse that contains JSON product information.
//     * @throws Exception
//     */
//    @Test
//    @DisplayName("메인 상품 요청 성공 케이스")
//    public void 메인상품요청_성공() throws Exception {
//        // given
//        final String mallName = "APM";
//        // custom response stub object
//        ApiResponse<MainProductResponse> successProductApiResponse = ApiResponse.ok(mainProductResponse);
//        given(mainController.handleGetProductsOfMall(mallName)).willAnswer(invocationOnMock -> successProductApiResponse);
//
//        // when
//        ResultActions resultActions = mockMvc.perform(
//                MockMvcRequestBuilders.get("/api/main/get/products/{mall_name}", mallName)
//                        .accept(MediaType.APPLICATION_JSON));
//
//
//        // then
//        resultActions.andExpect(status().isOk()).andDo(print());
//    }
//
//
//    @Test
//    @DisplayName("메인 상품 요청 실패 케이스")
//    public void 메인상품요청_실패() throws Exception {
//
//        // given
//        final String mallName = "APM";
//        // custom response stub object
//        ApiResponse<MainProductResponse> failProductApiResponse = ApiResponse.fail(mainProductResponse);
//
//        given(mainController.test()).willAnswer(invocationOnMock -> failProductApiResponse);
//
//        // when
//        ResultActions resultActions = mockMvc.perform(
//                MockMvcRequestBuilders.get("/api/main/test")
//                        .accept(MediaType.APPLICATION_JSON));
//
//        // then
//        resultActions.andExpect(status().is4xxClientError());
//
//
//    }
//
//    @Test
//    @DisplayName("MainProductResponse 생성 테스트")
//    public void MainProductResponse_생성(){
//        assertThat(mainProductResponse).isNotNull();
//        assertThat(mainProductResponse.getMall_id()).isEqualTo(1L);
//        assertThat(mainProductResponse.getMall_name()).isEqualTo("APM");
//
//    }
//
//    @Test
//    @DisplayName("MainShopInformation 생성 테스트")
//    public void MainShopInformation_생성() {
//        assertThat(mainShopInformation).isNotNull();
//        assertThat(mainShopInformation.getShop_id()).isEqualTo(1L);
//        assertThat(mainShopInformation.getShop_name()).isEqualTo("Lack");
//    }
//
//    @Test
//    @DisplayName("MainProductInformation 생성 테스트")
//    public void MainProductInformation_생성() {
//        assertThat(mainProductInformation.getMajor_category()).isEqualTo("상의");
//        assertThat(mainProductInformation.getSub_category()).isEqualTo("셔츠");
//    }
//}