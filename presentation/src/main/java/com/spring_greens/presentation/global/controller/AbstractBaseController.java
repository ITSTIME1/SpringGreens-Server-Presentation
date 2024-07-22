package com.spring_greens.presentation.global.controller;
import com.spring_greens.presentation.global.api.ApiResponse;
import com.spring_greens.presentation.global.redis.common.RedisProduct;
import com.spring_greens.presentation.global.redis.dto.request.RedisProductRequest;
import com.spring_greens.presentation.global.redis.service.RedisService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is abstract class for MapController and MainController. <br>
 * because Let's make one assumption that client want to get redis products so send to server HTTP GET request. <br>
 * then server response it. <br>
 *
 * but we need to consider how to handle common request. ( get product ) <br>
 * currently, client send request to server on map and main page. <br>
 *
 * if we define interface for map and main if so abstract method have to implement each.
 * but, it's way was not good solution. because of only get products to redis server and then convert to specific type response that's it <br>
 * so, I thought that implement a common processing logic by the abstract class. <br>
 * @author itstime0809
 */

@Slf4j
@RequiredArgsConstructor
public abstract class AbstractBaseController {
    private final RedisService redisService;

    @GetMapping("/get/products/{domain}/{mall_name}")
    @Operation(summary="상품 호출하기 메인 & 지도 공통")
    public ApiResponse<? extends RedisProduct<?>> getProductsOfMall(@PathVariable("domain") String domain,
                                                                    @PathVariable("mall_name") String mallName) {

        RedisProductRequest redisProductRequest = RedisProductRequest.builder().domain(domain).mallName(mallName).build();
        RedisProduct<?> product = redisService.getProductsFromRedisUsingKey(redisProductRequest);
        return ApiResponse.ok(product);
    }
}
