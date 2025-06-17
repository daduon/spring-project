package com.helper.checkResponse;

import java.time.LocalDateTime;

import lombok.*;

@Data
@Builder
public class BaseRest<T> {
    private Boolean status;
    private Integer code;
    private String message;
    private LocalDateTime timestamp;
    private T data;
}