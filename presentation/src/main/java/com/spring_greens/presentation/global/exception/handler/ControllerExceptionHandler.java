package com.spring_greens.presentation.global.exception.handler;
import com.spring_greens.presentation.global.api.ApiResponse;
import com.spring_greens.presentation.global.exception.CommonException;
import com.spring_greens.presentation.global.redis.exception.RedisException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * ControllerExceptionHandler handle global exceptions.
 * for example redis service occur exception what processing.
 * and this class processes using common ApiResponse specification.
 * @author itstime0809
 */
@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(CommonException.CustomNullPointerException.class)
    public ResponseEntity<ApiResponse<?>> handleNullPointerException (CommonException.CustomNullPointerException ex) {
        ApiResponse<?> response = ApiResponse.fail(ex.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(RedisException.RedisJsonProcessingException.class)
    public ResponseEntity<ApiResponse<?>> handleRedisJsonProcessingException (RedisException.RedisJsonProcessingException ex) {
        ApiResponse<?> response = ApiResponse.fail(ex.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
