package com.helper.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.helper.checkResponse.BaseError;

@RestControllerAdvice
public class ApiException {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(IllegalArgumentException.class)
    public BaseError<?> handleIllegalArgumentException(IllegalArgumentException e){
        return BaseError.builder()
                .status(false)
                .code(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .message(e.getMessage())
                .errors(e.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public BaseError<?> handleNumberFormatException(NumberFormatException e){
        return BaseError.builder()
                .status(false)
                .code(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .message(e.getMessage())
                .errors(e.getMessage())
                .build();
    }
}
