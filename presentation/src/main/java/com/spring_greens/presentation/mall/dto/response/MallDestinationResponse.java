package com.spring_greens.presentation.mall.dto.response;

import com.spring_greens.presentation.mall.dto.response.ifs.MallResponse;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MallDestinationResponse implements MallResponse {
    private Integer width;
    private Double latitude;
    private Double longitude;
}
