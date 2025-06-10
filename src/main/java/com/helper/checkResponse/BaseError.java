package com.helper.checkResponse;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BaseError<T> {
    private Boolean status;
    private Integer code;
    private String message;
    private LocalDateTime timestamp;
    private T errors;
}
