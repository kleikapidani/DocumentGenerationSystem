package com.documentgen.controller;

import com.documentgen.request.CreateTemplateSectionRequest;
import com.documentgen.response.CreateTemplateSectionResponse;
import com.documentgen.service.TemplateSectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/template/section")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TemplateSectionController {

    private final TemplateSectionService templateSectionService;

    @PostMapping(value = "/create")
    public ResponseEntity<CreateTemplateSectionResponse> createTemplateSection(@RequestBody CreateTemplateSectionRequest request) {
        CreateTemplateSectionResponse response = templateSectionService.createTemplateSection(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
