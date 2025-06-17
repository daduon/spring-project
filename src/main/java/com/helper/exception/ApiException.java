package com.helper.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.helper.checkResponse.BaseError;
import com.helper.checkResponse.BaseRestFactory;
@RestControllerAdvice
public class ApiException {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(IllegalArgumentException.class)
    public BaseError<?> IllegalArgumentException(IllegalArgumentException e){
        return BaseRestFactory.error(HttpStatus.NOT_FOUND.value(),e.getMessage(),null);
    }
}
