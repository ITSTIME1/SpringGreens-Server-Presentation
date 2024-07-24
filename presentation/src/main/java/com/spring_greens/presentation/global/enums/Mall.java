package com.spring_greens.presentation.global.enums;

import lombok.Getter;

@Getter
public enum Mall {
    APM(1L, "APM");
    private final Long mallId;
    private final String mallName;
    private Mall(Long mallId, String mallName) {
        this.mallId = mallId;
        this.mallName = mallName;
    }
}
