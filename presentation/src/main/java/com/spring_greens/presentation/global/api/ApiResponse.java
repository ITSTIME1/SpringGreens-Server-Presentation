package com.spring_greens.presentation.global.api;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.annotation.Nullable;
import lombok.Getter;
import org.springframework.http.HttpStatus;


/**
 * This common api response structure. <br>
 * It's generic class and T available every data-structure. <br>
 * Let's assume one situation that you try to send to client HTTP response. <br>
 * You may use this instance for sending HTTP response to client. <br>
 * Therefore, it's class is how to handle common responses.
 * @author itstime0809
 * @param <T> all data structure
 */
@Getter
public class ApiResponse<T> {
    private final int status_code;
    private final String message;
    private final T data;

    public ApiResponse(int status_code, String message, T data) {
        this.status_code = status_code;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponse<T> ok(@Nullable final T data) {
        return new ApiResponse<>(HttpStatus.OK.value(), "Success Request", data);
    }

    public static <T> ApiResponse<T> fail(@Nullable final T data) {
        return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), "Failed Request", data);
    }
    public static <T> ApiResponse<T> fail(@Nullable final String message, @Nullable final T data) {
        return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), message, data);
    }

}