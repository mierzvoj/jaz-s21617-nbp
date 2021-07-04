package com.example.pjatk.gold.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class globalExceptionHandler {
    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<AppError> handle4xx(HttpClientErrorException ex){
        HttpStatus statusCode = ex.getStatusCode();
        if(statusCode.value() == 404){
            // return ggg
        } else if (statusCode.value() == 400) {
            //return fff
        }
        System.out.println(ex);
        return ResponseEntity.status(statusCode)
                .body(new AppError(statusCode, ex.getResponseBodyAsString()));
    }
}
