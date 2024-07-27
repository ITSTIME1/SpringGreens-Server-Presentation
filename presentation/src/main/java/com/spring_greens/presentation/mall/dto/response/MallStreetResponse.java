package com.spring_greens.presentation.mall.dto.response;

import com.spring_greens.presentation.mall.dto.projection.Coordinate;
import com.spring_greens.presentation.mall.dto.response.ifs.MallResponse;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MallStreetResponse implements MallResponse {
    private Coordinate standard_position;
    private List<String> mall_name_list;
}
