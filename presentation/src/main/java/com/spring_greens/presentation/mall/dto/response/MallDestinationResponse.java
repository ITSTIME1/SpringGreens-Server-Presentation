package com.spring_greens.presentation.mall.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MallDestinationResponse {
    private Integer width;
    private Double latitude;
    private Double longitude;
}
