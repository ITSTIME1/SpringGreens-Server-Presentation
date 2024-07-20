package com.spring_greens.presentation.map.controller;

import com.spring_greens.presentation.global.api.ApiResponse;
import com.spring_greens.presentation.global.controller.AbstractBaseController;
import com.spring_greens.presentation.global.exception.CommonException;
import com.spring_greens.presentation.global.redis.common.RedisProduct;
import com.spring_greens.presentation.global.redis.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/map")
public class MapController extends AbstractBaseController {
    public MapController(RedisService redisService) {
        super(redisService);
    }

}
