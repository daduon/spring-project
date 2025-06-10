package com.helper.checkResponse;

import java.time.LocalDateTime;

import lombok.*;

@Data
@Builder
public class BaseError<T>{
    private Boolean status;
    private Integer code;
    private String message;
    private LocalDateTime timestamp;
    private T errors;
}