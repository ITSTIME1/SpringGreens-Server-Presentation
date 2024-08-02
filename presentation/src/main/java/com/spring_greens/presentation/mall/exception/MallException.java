package com.spring_greens.presentation.mall.exception;

public abstract class MallException extends RuntimeException{
    public MallException(String message) {
        super(message);
    }
    public static class MallEntityNotFoundException extends MallException {
        public MallEntityNotFoundException(String message) {
            super(message);
        }
    }
}
