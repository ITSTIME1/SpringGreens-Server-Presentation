package com.spring_greens.presentation.global.exception;

public class CommonException extends RuntimeException{
    public CommonException(String message) {
        super(message);
    }


    public static class CustomNullPointerException extends CommonException{
        public CustomNullPointerException (String message) {
            super(message);
        }

        public CustomNullPointerException() {
            this("Error data is null");
        }
    }
}
