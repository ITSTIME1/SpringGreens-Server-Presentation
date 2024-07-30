package com.spring_greens.presentation.mall.service.ifs;

import com.spring_greens.presentation.mall.dto.request.MallRequest;
import com.spring_greens.presentation.mall.dto.response.MallDestinationResponse;
import com.spring_greens.presentation.mall.dto.response.MallStreetResponse;

public interface MallService {
    MallStreetResponse getMallStreetInformation();

    MallDestinationResponse getMallDestinationInformation(MallRequest mallRequest);
}
