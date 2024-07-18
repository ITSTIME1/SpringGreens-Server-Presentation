package com.spring_greens.presentation.global.api;

import jakarta.annotation.Nullable;
import org.springframework.http.HttpStatus;


/**
 * This common api response structure. <br>
 * It's generic class and T available every data-structure. <br>
 * I should recommend that T is Object class. for example. let's make an assumption. <br>
 * If we use ok method for sending client result dataset, first make class for specific data. <br>
 * second we assign to status_code, etc. to that's class. at this time maybe we use common data. <br>
 * so this is a class that defines how to handle common data.
 * <br>
 * In addition, if you need to add a certain type of method. define below.
 * @author itstime0809
 * @param <T> all data-structure
 */
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

}