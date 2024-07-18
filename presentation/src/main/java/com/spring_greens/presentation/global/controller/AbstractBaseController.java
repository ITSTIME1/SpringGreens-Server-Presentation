package com.spring_greens.presentation.global.controller;

import com.spring_greens.presentation.global.api.ApiResponse;
import com.spring_greens.presentation.global.redis.entity.RedisProduct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is abstract class for controller layer. <br>
 * when client request to server to get a specific products of mall. <br>
 * Both MapController and MainController perform getProductsOfMall. <br>
 * so, It made abstract class contained with getProductsOfMall. <br>
 * and then, use template method pattern because the type of processing was different.
 * <br>
 * @author itstime0809
 */
@RestController
@Slf4j
public abstract class AbstractBaseController {

    @GetMapping("/get/products/{domain}/{mall_name}")
    public ApiResponse<? extends RedisProduct<?>>
    getProductsOfMall(@PathVariable("domain") final String domain, @PathVariable("mall_name") final String mallName) {
        return handleGetProductsOfMall(domain, mallName);
    }

    protected abstract ApiResponse<? extends RedisProduct<?>>
    handleGetProductsOfMall(String domain, String mallName);
}
