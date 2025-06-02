package com.example.koaguide.util;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Map<String, Object>> handleResponseStatusException(ResponseStatusException ex) {
        Map<String, Object> errorBody = new HashMap<>();
        errorBody.put("timestamp", LocalDateTime.now().toString());
        errorBody.put("status", ex.getStatusCode().value());
        errorBody.put("error", HttpStatus.valueOf(ex.getStatusCode().value()).getReasonPhrase());
        errorBody.put("message", ex.getReason());  // <-- đây là message bạn muốn
        return new ResponseEntity<>(errorBody, HttpStatus.valueOf(ex.getStatusCode().value()));
    }

    // Bạn có thể thêm các handler khác nếu muốn
}