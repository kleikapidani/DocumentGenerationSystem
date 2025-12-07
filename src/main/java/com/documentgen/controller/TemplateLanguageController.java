package com.documentgen.controller;

import com.documentgen.response.TemplateLanguageResponse;
import com.documentgen.service.TemplateLanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/template-language")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TemplateLanguageController {

    private final TemplateLanguageService templateLanguageService;

    @GetMapping
    public ResponseEntity<List<TemplateLanguageResponse>> extractTemplateLanguageList() {
        List<TemplateLanguageResponse> templateLanguageResponseList = templateLanguageService.extractTemplateLanguageList();
        return ResponseEntity.ok(templateLanguageResponseList);
    }
}
