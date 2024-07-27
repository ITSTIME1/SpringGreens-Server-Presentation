package com.spring_greens.presentation.map.controller;

import com.spring_greens.presentation.global.api.ApiResponse;
import com.spring_greens.presentation.global.controller.AbstractBaseController;
import com.spring_greens.presentation.global.redis.service.RedisService;
import com.spring_greens.presentation.mall.dto.request.MallRequest;
import com.spring_greens.presentation.mall.dto.response.ifs.MallResponse;
import com.spring_greens.presentation.mall.service.ifs.MallService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/map")
public class MapController extends AbstractBaseController {
    public MapController(MallService mallService, RedisService redisService) {
        super(mallService, redisService);
    }

    @GetMapping("/get/mall/street")
    @Operation(summary = "상가거리이동 정보 제공", description = "상가거리 이동시, 기준 좌표와 마커 표시를 위한 좌표값 제공")
    public ApiResponse<MallResponse> moveMallStreet() {
        MallResponse mallStreetResponse = mallService.getMallStreetInformation();
        return ApiResponse.ok(mallStreetResponse);
    }

    @GetMapping("/set/destination/{mall_name}")
    @Operation(summary = "목적지 설정", description = "목적지 설정 클릭시 상가의 너비, 위도, 경도값 제공")
    public ApiResponse<MallResponse> setDestination(@PathVariable("mall_name") String mallName) {
        MallRequest mallRequest = MallRequest.builder().name(mallName).build();
        MallResponse mallDestinationResponse = mallService.getMallDestinationInformation(mallRequest);
        return ApiResponse.ok(mallDestinationResponse);
    }
}
