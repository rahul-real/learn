package com.rahul.learn.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.rahul.learn.exceptionhandler.GlobalExceptionHandler.ValidationError;

import lombok.Data;

@Data
public class ExceptionMessage {

    private LocalDateTime timestamp;
    private int httpCode;
    private List<ValidationError> validationError;
}
