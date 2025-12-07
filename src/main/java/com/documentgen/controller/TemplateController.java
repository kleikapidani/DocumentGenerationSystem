package com.documentgen.controller;

import com.documentgen.request.CreateTemplateRequest;
import com.documentgen.response.CreateTemplateResponse;
import com.documentgen.service.TemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/template")
@RequiredArgsConstructor
public class TemplateController {

    private final TemplateService templateService;

    @PostMapping(value = "/create")
    public ResponseEntity<CreateTemplateResponse> createTemplate(@RequestBody CreateTemplateRequest request) {
        CreateTemplateResponse response = templateService.createTemplate(request);
        return ResponseEntity.ok(response);
    }
}
