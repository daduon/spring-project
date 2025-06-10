package com.helper.checkResponse;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record BaseError<T>(
        Boolean status,
        Integer code,
        String message,
        LocalDateTime timestamp,
        T errors
) {
    
    public static <T> BaseErrorBuilder<T> builder(){
        return new BaseErrorBuilder<>();
    }
    public static class BaseErrorBuilder<T> {
        private Boolean status;
        private Integer code;
        private String message;
        private LocalDateTime timestamp;
        private T errors;

        public BaseErrorBuilder<T> status(Boolean status) {
            this.status = status;
            return this;
        }

        public BaseErrorBuilder<T> code(Integer code) {
            this.code = code;
            return this;
        }

        public BaseErrorBuilder<T> message(String message) {
            this.message = message;
            return this;
        }

        public BaseErrorBuilder<T> timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public BaseErrorBuilder<T> errors(T errors) {
            this.errors = errors;
            return this;
        }

        public BaseError<T> build() {
            return new BaseError<>(status, code, message, timestamp, errors);
        }
    }
}
