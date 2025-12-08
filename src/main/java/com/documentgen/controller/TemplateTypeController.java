package com.documentgen.controller;

import com.documentgen.request.CreateTemplateTypeRequest;
import com.documentgen.response.TemplateTypeResponse;
import com.documentgen.service.TemplateTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/template-type")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TemplateTypeController {

    private final TemplateTypeService templateTypeService;

    @GetMapping
    public ResponseEntity<List<TemplateTypeResponse>> extractTemplateTypeList() {
        List<TemplateTypeResponse> templateTypeResponseList = templateTypeService.extractTemplateTypeList();
        return ResponseEntity.ok(templateTypeResponseList);
    }

    @PostMapping
    public ResponseEntity<TemplateTypeResponse> createTemplateType(CreateTemplateTypeRequest request) {
        TemplateTypeResponse templateTypeResponse = templateTypeService.createTemplateType(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(templateTypeResponse);
    }
}
