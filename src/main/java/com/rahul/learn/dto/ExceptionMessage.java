package com.rahul.learn.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.rahul.learn.exceptionhandler.GlobalExceptionHandler.ValidationError;

import lombok.Data;

/**
 * @author rahul
   @since  09-Jan-2024 2024 1:10:18 pm
 */
@Data
public class ExceptionMessage {

    private LocalDateTime timestamp;
    private int httpCode;
    private List<ValidationError> validationError;
}
