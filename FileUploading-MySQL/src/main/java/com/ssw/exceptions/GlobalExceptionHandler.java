package com.ssw.exceptions;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ssw.app.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ApiResponse> handleIOException(IOException e) {
    	
       // ApiResponse response = new ApiResponse("Some Error Occurred");
    	
    	ApiResponse response = ApiResponse.builder().resp("Some Error Occurred").build();
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        
        
    }
}



