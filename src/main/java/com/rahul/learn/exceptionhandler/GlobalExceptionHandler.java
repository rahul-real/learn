package com.rahul.learn.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rahul.learn.dto.ExceptionMessage;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
@Validated
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionMessage> handleValidationException(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        ExceptionMessage exceptionMessage = new ExceptionMessage();
//        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
        exceptionMessage.setHttpCode(HttpStatus.BAD_REQUEST.value());
        LocalDateTime localDateTime = LocalDateTime.now();
        exceptionMessage.setTimestamp(localDateTime);
        List<ValidationError> ValidationError = new ArrayList<ValidationError>();
        for(FieldError fieldError : fieldErrors) {
            String fieldName = fieldError != null ? fieldError.getField() : "Unknown field";
            String errorMessage = fieldError != null ? fieldError.getDefaultMessage() : "Validation error";

            ValidationError validationError = new ValidationError(
                    fieldName,
                    errorMessage
            );
            ValidationError.add(validationError);
        	
        }
        exceptionMessage.setValidationError(ValidationError);

        return new ResponseEntity<>(exceptionMessage,HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ValidationError> handleValidationException(ConstraintViolationException ex) {
//    	Set<ConstraintViolation<?>> exc=  ex.getConstraintViolations();
//    	ex.getClass();
    	List<String> errors = Collections.singletonList(ex.getMessage());
        String fieldName = errors != null ? ex.getClass().toString() : "Unknown field";
        String errorMessage = errors != null ? ex.getLocalizedMessage() : "Validation error";
        ValidationError validationError = new ValidationError(
                fieldName,
                errorMessage
        );

        return new ResponseEntity<>(validationError,HttpStatus.BAD_REQUEST);
    }
    
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
//        List<String> errors = ex.getBindingResult().getFieldErrors()
//                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
//        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
//    }
//
//    private Map<String, List<String>> getErrorsMap(List<String> errors) {
//        Map<String, List<String>> errorResponse = new HashMap<>();
//        errorResponse.put("errors", errors);
//        return errorResponse;
//    }

    // Custom class to represent the structure of the error response
    public static class ValidationError {
        private String field;
        private String message;

        public ValidationError(String field, String message) {
            this.field = field;
            this.message = message;
        }

        public String getField() {
            return field;
        }

        public String getMessage() {
            return message;
        }
    }
}
