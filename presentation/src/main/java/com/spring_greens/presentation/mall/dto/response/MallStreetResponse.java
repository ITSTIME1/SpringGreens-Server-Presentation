package com.spring_greens.presentation.mall.dto.response;

import com.spring_greens.presentation.mall.dto.projection.Coordinate;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MallStreetResponse {
    private Coordinate standard_position;
    private List<String> mall_name_list;
}
