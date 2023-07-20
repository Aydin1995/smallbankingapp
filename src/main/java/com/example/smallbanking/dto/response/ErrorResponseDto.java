package com.example.smallbanking.dto.response;

public class ErrorResponseDto {

 private Integer code;
 private String status;
 private String errorMessage;

    public Integer getCode() {
        return code;
    }

    public ErrorResponseDto setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public ErrorResponseDto setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public ErrorResponseDto setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }
}
