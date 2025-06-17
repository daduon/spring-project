package com.helper.checkResponse;

import java.time.LocalDateTime;

public class BaseRestFactory {
    public static <T> BaseRest<T> success(T data) {
        return BaseRest.<T>builder()
            .status(true)
            .code(200)
            .message("OK")
            .timestamp(LocalDateTime.now())
            .data(data)
            .build();
    }

    public static <T> BaseError<T> error(int code, String msg, T errors) {
        return BaseError.<T>builder()
            .status(false)
            .code(code)
            .message(msg)
            .timestamp(LocalDateTime.now())
            .errors(errors)
            .build();
    }
}
