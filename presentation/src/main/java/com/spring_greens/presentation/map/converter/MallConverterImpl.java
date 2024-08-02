package com.spring_greens.presentation.map.converter;

import com.spring_greens.presentation.mall.dto.projection.Coordinate;
import com.spring_greens.presentation.mall.dto.projection.Destination;
import com.spring_greens.presentation.mall.dto.request.MallRequest;
import com.spring_greens.presentation.mall.dto.response.MallDestinationResponse;
import com.spring_greens.presentation.mall.dto.response.MallStreetResponse;
import com.spring_greens.presentation.map.converter.ifs.MallConverter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MallConverterImpl implements MallConverter {
    @Override
    public MallRequest createRequest() {
        return MallRequest.builder().build();
    }
    @Override
    public MallRequest createRequest(String mallName) {
        return MallRequest.builder().name(mallName).build();
    }

    @Override
    public MallStreetResponse createMallStreetResponse(Coordinate coordinate, List<String> mallNameList) {
        return MallStreetResponse.builder()
                .standard_position(coordinate)
                .mall_name_list(mallNameList)
                .build();
    }

    @Override
    public MallDestinationResponse createMallDestinationResponse(Destination destination) {
        return MallDestinationResponse.builder()
                .width(destination.getWidth())
                .latitude(destination.getLatitude())
                .longitude(destination.getLongitude())
                .build();
    }
}
