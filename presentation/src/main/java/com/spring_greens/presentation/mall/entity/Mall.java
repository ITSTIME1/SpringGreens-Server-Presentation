package com.spring_greens.presentation.mall.entity;

import jakarta.persistence.*;
import jdk.jfr.Description;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Mall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Description("상가이름")
    private String name;

    @Description("상가전화번호")
    private String contact;

    @Description("위도")
    private Double latitude;

    @Description("경도")
    private Double longitude;

    @Description("상가너비")
    private Integer width;

    @Column(name = "start_time")
    @Description("영업시작시간")
    private LocalTime startTime;

    @Column(name = "end_time")
    @Description("영업종료시간")
    private LocalTime endTime;

    @Column(name = "road_address")
    @Description("도로명주소")
    private String roadAddress;

    @Column(name = "address_details")
    @Description("상세주소")
    private String addressDetails;

    @Column(name = "registration_date")
    @Description("상가등록일")
    private LocalDateTime registrationDate;
}
