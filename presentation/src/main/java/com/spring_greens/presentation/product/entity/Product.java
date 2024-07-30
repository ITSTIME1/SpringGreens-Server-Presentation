package com.spring_greens.presentation.product.entity;


import jakarta.persistence.*;
import jdk.jfr.Description;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer price;

    @Description("단위")
    private String unit;
    private String content;

    @Description("상품 재고 상태")
    private Boolean stockStatus;

    @Description("평점수")
    private Byte rating;

    @Column(name = "registration_date_time")
    @Description("등록일")
    private LocalDateTime registrationDateTime;

    @Column(name = "last_change_date_time")
    @Description("마지막변경일")
    private LocalDateTime lastChangeDateTime;

    @Column(name = "total_viewers")
    @Description("누적뷰어수")
    private Integer totalViewers;

    @Description("주기")
    private Integer age;

    @Column(name = "details_product_click_count")
    @Description("상품상세클릭수")
    private Integer detailsProductClickCount;
    @Column(name = "daily_ad_impressions")
    @Description("하루광고노출수")
    private Integer dailyAdImpressions;

    @Column(name = "extractable_status")
    @Description("마지막 추출 상태")
    private Boolean extractableStatus;

    @Column(name = "last_extract_date")
    @Description("마지막 추출 날짜")
    private LocalDate lastExtractDate;
}
