package com.spring_greens.presentation.map.converter.ifs;

import com.spring_greens.presentation.mall.dto.request.MallRequest;

public interface MallConverter  {

    MallRequest createRequest();
    MallRequest createRequest(String mallName);
}
