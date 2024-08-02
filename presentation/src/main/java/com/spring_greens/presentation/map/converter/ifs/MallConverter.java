package com.spring_greens.presentation.map.converter.ifs;

import com.spring_greens.presentation.mall.dto.projection.Coordinate;
import com.spring_greens.presentation.mall.dto.projection.Destination;
import com.spring_greens.presentation.mall.dto.request.MallRequest;
import com.spring_greens.presentation.mall.dto.response.MallDestinationResponse;
import com.spring_greens.presentation.mall.dto.response.MallStreetResponse;

import java.util.List;

public interface MallConverter  {

    MallRequest createRequest();
    MallRequest createRequest(String mallName);

    MallStreetResponse createMallStreetResponse(Coordinate coordinate, List<String> mallNameList);
    MallDestinationResponse createMallDestinationResponse(Destination destination);
}
