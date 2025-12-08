package com.documentgen.controllerException;

import com.documentgen.controller.TemplateController;
import com.documentgen.exception.TemplateLanguageNotFoundException;
import com.documentgen.exception.TemplateTypeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice(basePackageClasses = {TemplateController.class})
public class TemplateControllerAdvice {

    @ExceptionHandler(value = TemplateLanguageNotFoundException.class)
    public ResponseEntity<Map<String, Object>> templateLanguageExceptionHandler(TemplateLanguageNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of(
                        "message", ex.getMessage(),
                        "timestamp", LocalDateTime.now(),
                        "cause", ex.getCause()
                )
        );
    }

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
