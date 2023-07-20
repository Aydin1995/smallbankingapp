package com.example.smallbanking.globalexception;


import com.example.smallbanking.dto.response.ErrorResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponseDto> handleExceptions(RuntimeException e) {
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(
                new ErrorResponseDto()
                        .setCode(INTERNAL_SERVER_ERROR.value())
                        .setStatus("ERROR")
                        .setErrorMessage(e.getMessage()));

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleExceptions(Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(
                new ErrorResponseDto()
                        .setCode(INTERNAL_SERVER_ERROR.value())
                        .setStatus("ERROR")
                        .setErrorMessage(e.getMessage()));

    }


}


