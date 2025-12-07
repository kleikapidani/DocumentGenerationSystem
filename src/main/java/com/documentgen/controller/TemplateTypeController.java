package com.documentgen.controller;

import com.documentgen.response.TemplateTypeResponse;
import com.documentgen.service.TemplateTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/template-type")
@RequiredArgsConstructor
public class TemplateTypeController {

    private final TemplateTypeService templateTypeService;

    @GetMapping
    public ResponseEntity<List<TemplateTypeResponse>> extractTemplateTypeList() {
        List<TemplateTypeResponse> templateTypeResponseList = templateTypeService.extractTemplateTypeList();
        return ResponseEntity.ok(templateTypeResponseList);
    }
}
