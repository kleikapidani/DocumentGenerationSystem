package com.documentgen.exception;

public class TemplateLanguageNotFoundException extends RuntimeException {
    public TemplateLanguageNotFoundException(String message) {
        super(message);
    }
}
