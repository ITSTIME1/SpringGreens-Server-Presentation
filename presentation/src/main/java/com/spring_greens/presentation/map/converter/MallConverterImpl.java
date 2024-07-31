package com.spring_greens.presentation.map.converter;

import com.spring_greens.presentation.mall.dto.request.MallRequest;
import com.spring_greens.presentation.map.converter.ifs.MallConverter;
import org.springframework.stereotype.Component;

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
}
