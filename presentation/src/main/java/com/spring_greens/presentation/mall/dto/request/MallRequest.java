package com.spring_greens.presentation.mall.dto.request;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Builder
public class MallRequest  {
    private Long id;
    private String name;
    private String contact;
    private Double latitude;
    private Double longitude;
    private Integer width;
    private LocalTime startTime;
    private LocalTime endTime;
    private String roadAddress;
    private String addressDetails;
    private LocalDateTime registrationDate;
}
