package com.example.pjatk.gold.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


public class AppError {
    private final HttpStatus httpStatus;
    private final String cause;

    public AppError(HttpStatus httpStatus, String cause) {
        this.httpStatus = httpStatus;
        this.cause = cause;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getCause() {
        return cause;
    }
}
