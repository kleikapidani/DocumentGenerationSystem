package com.documentgen.exception;

public class TemplateTypeNotFoundException extends RuntimeException {
    public TemplateTypeNotFoundException(String message) {
        super(message);
    }
}
