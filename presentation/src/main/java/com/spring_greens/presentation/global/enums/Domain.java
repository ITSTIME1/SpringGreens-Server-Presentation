package com.spring_greens.presentation.global.enums;

import lombok.Getter;

@Getter
public enum Domain {
    MAP("map"),
    MAIN("main");
    private final String domain;

    private Domain(String domain) {
        this.domain = domain;
    }
}