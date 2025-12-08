package com.documentgen.controllerException;

import com.documentgen.controller.TemplateTypeController;
import com.documentgen.exception.TemplateTypeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice(basePackageClasses = {TemplateTypeController.class})
public class TemplateTypeControllerAdvice {
    @ExceptionHandler(value = TemplateTypeNotFoundException.class)
    public ResponseEntity<Map<String, Object>> templateTypeNotFoundExceptionHandler(TemplateTypeNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of(
                    "message", ex.getMessage(),
                    "timestamp", LocalDateTime.now(),
                    "cause", ex.getCause()
                )
        );
    }
}
