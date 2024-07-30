package com.spring_greens.presentation.mall.service;

import com.spring_greens.presentation.mall.dto.projection.Coordinate;
import com.spring_greens.presentation.mall.dto.projection.Destination;
import com.spring_greens.presentation.mall.dto.request.MallRequest;
import com.spring_greens.presentation.mall.dto.response.MallDestinationResponse;
import com.spring_greens.presentation.mall.dto.response.MallStreetResponse;
import com.spring_greens.presentation.mall.exception.MallException;
import com.spring_greens.presentation.mall.repository.MallRepository;
import com.spring_greens.presentation.mall.service.ifs.MallService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * With this purpose in mind, we hope to give some practical education to our students. as to how is done
 */
@Service
@RequiredArgsConstructor
public class MallServiceImpl implements MallService {
    private final MallRepository mallRepository;
    @Override
    public MallStreetResponse getMallStreetInformation() {
        List<String> mallNameList = mallRepository.findAllMallName();
        Coordinate coordinate = mallRepository.findStandardCoordinate();
        return MallStreetResponse.builder()
                .standard_position(coordinate)
                .mall_name_list(mallNameList).build();
    }


    @Override
    public MallDestinationResponse getMallDestinationInformation(MallRequest mallRequest) {
        try {
            Destination destination = mallRepository.findMallDestination(mallRequest.getName());
            return MallDestinationResponse.builder()
                    .width(destination.getWidth())
                    .latitude(destination.getLatitude())
                    .longitude(destination.getLongitude())
                    .build();
        } catch (NullPointerException e) {
            throw new MallException.MallEntityNotFoundException();
        }
    }
}
