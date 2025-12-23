package com.example.Blog_App.advice;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiError {



    public ApiError() {
        this.timestamp = LocalDateTime.now();
    }

    public ApiError(HttpStatus status, String error) {
        this();
        this.status = status;
        this.error = error;
    }

    private LocalDateTime timestamp;
    private String error;
    private HttpStatus status;


}
