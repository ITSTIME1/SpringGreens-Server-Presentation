package com.spring_greens.presentation.global.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ApiMessage {
    SUCCESS(HttpStatus.OK, "Success Request"),
    FAIL(HttpStatus.BAD_REQUEST, "Failed Request");

    private final HttpStatus status;
    private final String responseMessage;

    ApiMessage(HttpStatus httpStatus, String responseMessage) {
        this.status = httpStatus;
        this.responseMessage = responseMessage;
    }
}
