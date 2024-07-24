package com.spring_greens.presentation.global.redis.exception;

import io.lettuce.core.models.role.RedisInstance;

public abstract class RedisException extends RuntimeException{
    public RedisException(String message) {
        super(message);
    }


    /**
     * When you try to readValue of objectMapper. there is a possibility of making JsonProcessingException exception.
     * if we need to specific handle this exception, we can handle where it below.
     * @author itstime0809
     */
    public static class RedisJsonProcessingException extends RedisException{
        public RedisJsonProcessingException(String message) {
            super(message);
        }
    }

    public static class RedisIllegalArgumentException extends RedisException {
        public RedisIllegalArgumentException(String message) { super(message);}
    }
}
