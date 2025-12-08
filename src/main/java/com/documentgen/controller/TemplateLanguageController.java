package com.documentgen.controller;

import com.documentgen.request.CreateTemplateLanguageRequest;
import com.documentgen.response.TemplateLanguageResponse;
import com.documentgen.service.TemplateLanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<TemplateLanguageResponse> createTemplateLanguage(@RequestBody CreateTemplateLanguageRequest request) {
        TemplateLanguageResponse templateLanguageResponse = templateLanguageService.createTemplateLanguage(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(templateLanguageResponse);
    }
}
