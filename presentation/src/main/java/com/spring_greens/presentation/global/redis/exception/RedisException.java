package com.spring_greens.presentation.global.redis.exception;

public class RedisException extends RuntimeException{
    public RedisException(String message) {
        super(message);
    }
    public static class RedisJsonProcessingException extends RedisException{
        public RedisJsonProcessingException(String message) {
            super(message);
        }
        public RedisJsonProcessingException() {
            this("Error parsing json data");
        }
    }
}
