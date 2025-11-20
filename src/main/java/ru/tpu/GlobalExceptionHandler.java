package ru.tpu;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<?> handleUserNotFoundException(final UserNotFoundException exception){
        return ResponseEntity.status(exception.getHttpStatus()).body(exception.getMessage());
    }
}

